# Large-Scale Data Management Systems - Coursework

This repository contains the deliverables for the "Large-Scale Data Management Systems" course. The coursework focuses on advanced data architectural patterns, specifically Data Warehousing and Graph Databases.

---

## 1. Data Warehouse Implementation (Apache Spark & Power BI)
**Topic:** Implementation of a Data Warehouse for analyzing Los Angeles crime data (2020-2023).

This project involved the end-to-end development of a system designed to track crime trends, victim demographics, and geographic hotspots.

### Key Components:
* **Star Schema Architecture:** Designed a multidimensional model consisting of a central Fact Table and Dimension Tables for Time, Area, Crime Type, Victim characteristics, and Case Status.
* **ETL with Apache Spark:** Developed a program in Spark to process the large-scale `crimeData.csv` dataset, perform data cleaning, and populate the star schema.
* **Analytical Reports:** Generated statistical insights including monthly crime trends, top 10 crime descriptions, and crime status per category.
* **Data Cube & Visualization:** Created a multidimensional data cube for demographic analysis and an interactive Power BI dashboard for visual reporting.

---

## 2. Graph Database Modeling & Querying (Neo4j)
**Topic:** Property Graph modeling and complex relationship analysis of European Football Data (2022-2023).

The second project focused on leveraging NoSQL Graph technology to manage and query highly interconnected football statistics across 14 European leagues.

### Key Components:
* **Property Graph Design:** Modeled entities (Players, Teams, Competitions) as nodes and defined relationships with specific properties to avoid data redundancy.
* **Cypher Implementation:** Developed Cypher scripts for bulk data loading and high-performance querying of the Neo4j database.
* **Complex Relationship Analysis:** * Identified player transfers between the Greek league and foreign championships.
    * Calculated team-specific statistics such as top scorers and league standings.
    * Implemented a custom `TEAMMATES` relationship to identify "pivotal" players and the most frequent attacking duos based on shared minutes in matches.

---

## Technologies Used
* **Big Data Processing:** Apache Spark (Python)
* **Graph Database:** Neo4j & Cypher Query Language
* **Business Intelligence:** Power BI
* **Data Modeling:** Star Schema, Property Graph