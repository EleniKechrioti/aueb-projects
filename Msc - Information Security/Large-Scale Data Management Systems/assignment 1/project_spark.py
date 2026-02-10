# Eleni Kechrioti
# F3312503

from pyspark.sql import SparkSession
from pyspark.sql.functions import col, month, year, dayofmonth, to_date, desc, count, concat_ws, lit

# Initialize Spark Session
spark = SparkSession.builder \
    .appName("LargeScaleDataManagement_Project") \
    .getOrCreate()

# Load and Prepare Data
INPUT_FILE = "CrimeData.csv"
OUTPUT_DIR = "csv_output"

try:
    df_raw = spark.read.csv(INPUT_FILE, header=True, sep=";", inferSchema=True)
    
    # Ensure 'latitude' and 'longitude' are capitalized
    if 'latitude' in df_raw.columns:
        df_raw = df_raw.withColumnRenamed('latitude', 'Latitude')
    if 'longitude' in df_raw.columns:
        df_raw = df_raw.withColumnRenamed('longitude', 'Longitude')

    df_raw = df_raw.withColumn("DateOccured", to_date(col("DateOccured"), "yyyy-MM-dd"))

except Exception as e:
    print(f"ERROR while loading {INPUT_FILE}: {e}")
    spark.stop()
    exit()

print("Raw data loaded and prepared.")

# STAR Schema Creation

# DimTime (Time)
dim_time = df_raw.select(col("DateOccured")).distinct().withColumn(
    "Year", year(col("DateOccured"))
).withColumn(
    "Month", month(col("DateOccured"))
).withColumn(
    "Day", dayofmonth(col("DateOccured"))
).withColumn(
    "TimeKey", concat_ws("-", col("Year"), col("Month"), col("Day"))
) 
dim_time.createOrReplaceTempView("DimTime")


# DimWeapon
dim_weapon = df_raw.select(
    col("WeaponCode").cast("string").alias("WeaponKey"),
    col("Weapon").alias("WeaponDescription")
).distinct()
dim_weapon.createOrReplaceTempView("DimWeapon")


# DimCaseStatus
dim_casestatus = df_raw.select(
    col("CaseStatusCode").alias("StatusKey"),
    col("CaseStatusDescription").alias("StatusDescription")
).distinct()
dim_casestatus.createOrReplaceTempView("DimCaseStatus")


# DimCrimeType
dim_crimetype = df_raw.select(
    col("CrimeCode").alias("CrimeKey"),
    col("CrimeDescription").alias("CrimeDescription")
).distinct()
dim_crimetype.createOrReplaceTempView("DimCrimeType")


# DimArea
dim_area = df_raw.select(
    col("AreaCode").alias("AreaKey"),
    col("Area").alias("AreaName")
).distinct()
dim_area.createOrReplaceTempView("DimArea")


# DimPremis
dim_premis = df_raw.select(
    col("PremisCode").cast("string").alias("PremisKey"),
    col("PremisDescription").alias("PremisDescription")
).distinct()
dim_premis.createOrReplaceTempView("DimPremis")


# DimVictim
# key does not exist
# We create a composite key that contains the other columns
dim_victim = df_raw.select(
    concat_ws("-", col("VictimAge"), col("VictimSex"), col("VictimDescentCode")).alias("VictimKey"),
    col("VictimAge").alias("Age"),
    col("VictimSex").alias("Sex"),
    col("VictimDescentCode").alias("DescentCode"),
    col("VictimDescent").alias("DescentDescription")
).distinct()
dim_victim.createOrReplaceTempView("DimVictim")


# FACT TABLE
fact_crime = df_raw.select(
    col("CaseID"),
    col("Latitude"),
    col("Longitude"),
    
    # Time Key
    concat_ws("-", year(col("DateOccured")), month(col("DateOccured")), dayofmonth(col("DateOccured"))).alias("TimeKey"),
    
    # Victim Key
    concat_ws("-", col("VictimAge"), col("VictimSex"), col("VictimDescentCode")).alias("VictimKey"), 
    
    col("AreaCode").alias("AreaKey"), 
    col("PremisCode").cast("string").alias("PremisKey"), 
    col("WeaponCode").cast("string").alias("WeaponKey"), 
    col("CaseStatusCode").alias("StatusKey"),
    col("CrimeCode").alias("CrimeKey"),
    
    lit(1).alias("IncidentCount")
)
fact_crime.createOrReplaceTempView("FactCrime")


print("STAR Schema built successfully.")
print("-" * 50)


#Report 1: Total incidents by Area and Premise Description
report1_query = """
SELECT
    A.AreaName AS Area,
    P.PremisDescription AS Premise_Description,
    COUNT(F.CaseID) AS Incident_Count
FROM
    FactCrime F
JOIN DimArea A ON F.AreaKey = A.AreaKey
JOIN DimPremis P ON F.PremisKey = P.PremisKey
GROUP BY
    A.AreaName, P.PremisDescription
ORDER BY
    Area ASC, Incident_Count DESC
"""
report1_df = spark.sql(report1_query)
print("Report 1 (Area, Premise): Completed.")

# Report 2: Top 10 Crime Descriptions
report2_query = """
SELECT
    C.CrimeDescription AS Crime_Type,
    COUNT(F.CaseID) AS Incident_Count
FROM
    FactCrime F
JOIN DimCrimeType C ON F.CrimeKey = C.CrimeKey
GROUP BY
    C.CrimeDescription
ORDER BY
    Incident_Count DESC
LIMIT 10
"""
report2_df = spark.sql(report2_query)
print("Report 2 (Top 10 Crimes): Completed.")

# Report 3: Monthly number of incidents per year
report3_query = """
SELECT
    T.Year AS Year,
    T.Month AS Month,
    COUNT(F.CaseID) AS Incident_Count
FROM
    FactCrime F
JOIN DimTime T ON F.TimeKey = T.TimeKey
GROUP BY
    T.Year, T.Month
ORDER BY
    Year ASC, Month ASC
"""
report3_df = spark.sql(report3_query)
print("Report 3 (Monthly Incidents): Completed.")


# Report 4: Incident status by crime type
report4_query = """
SELECT
    C.CrimeDescription AS Crime_Type,
    CS.StatusDescription AS Incident_Status,
    COUNT(F.CaseID) AS Incident_Count
FROM
    FactCrime F
JOIN DimCrimeType C ON F.CrimeKey = C.CrimeKey
JOIN DimCaseStatus CS ON F.StatusKey = CS.StatusKey
GROUP BY
    C.CrimeDescription, CS.StatusDescription
ORDER BY
    Crime_Type ASC, Incident_Status ASC
"""
report4_df = spark.sql(report4_query)
print("Report 4 (Crime, Status): Completed.")


# Report 5: Data Cube - Total incidents by victim descent, sex, and age
report5_df = fact_crime.join(dim_victim, fact_crime.VictimKey == dim_victim.VictimKey) \
    .cube(col("DescentDescription"), col("Sex"), col("Age")) \
    .agg(count(col("CaseID")).alias("Incident_Count")) \
    .orderBy(col("Incident_Count").desc()) \
    .withColumnRenamed("DescentDescription", "Victim_Descent") \
    .withColumnRenamed("Sex", "Victim_Sex") \
    .withColumnRenamed("Age", "Victim_Age")

print("Report 5 (Data Cube): Completed.")
print("-" * 50)

# Save Results to CSV 
print(f"Saving Schema Tables and Reports to CSV in the '{OUTPUT_DIR}' directory...")

dataframes_to_save = {
    # STAR Schema Tables
    "FactCrime": fact_crime,
    "DimTime": dim_time,
    "DimArea": dim_area,
    "DimPremis": dim_premis,
    "DimWeapon": dim_weapon,
    "DimCaseStatus": dim_casestatus,
    "DimCrimeType": dim_crimetype,
    "DimVictim": dim_victim,
    # Statistical Reports
    "Report1_Area_Premis": report1_df,
    "Report2_Top10Crime": report2_df,
    "Report3_MonthlyIncidents": report3_df,
    "Report4_StatusByCrime": report4_df,
    "Report5_DataCube": report5_df,
}

for name, df in dataframes_to_save.items():
    output_path = f"{OUTPUT_DIR}/{name}"
    try:
        df.repartition(1).write.csv(
            output_path,
            header=True,
            mode="overwrite"
        )
        print(f"Saved: {output_path}")
    except Exception as e:
        print(f"ERROR saving {name}: {e}")

spark.stop()
print("-" * 50)