import pyodbc
import numpy as np
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import axes3d

server = 'mysqlserver.database.windows.net'
database = 'ExercisesDatabase'
username = 'examiner'
password = 'pass'

cnxn = pyodbc.connect('DRIVER={ODBC Driver 17 for SQL Server};SERVER='+server+';DATABASE='+database+';UID='+username+';PWD='+ password)

cursor = cnxn.cursor()

# erotima 1
cursor.execute('SELECT YEAR(release_date) as year1, COUNT(id) as movies_per_year FROM movie WHERE release_date is not null and budget is not null GROUP BY YEAR(release_date) HAVING SUM(CAST( budget AS bigint)) > 1000000 ORDER BY year1;')
rows = cursor.fetchall()
x = [rows[i][0] for i in range(len(rows))]
# for i in x:
#     print(i)
y = [rows[i][1] for i in range(len(rows))]
# for i in y:
#     print(i)
# for i in cursor:
#     print(i)


plt.suptitle('Number of movies released per year (erotima 1)')
plt.xlabel('year')
plt.ylabel('movies_per_year')
plt.bar(x,y)
plt.show()

# erotima 2
cursor.execute('SELECT genre.name, COUNT(movie.id) as movies_per_genre FROM movie, genre, hasGenre WHERE movie.id = hasGenre.movie_id AND genre.id = hasGenre.genre_id GROUP BY genre.name HAVING SUM(CAST( budget AS bigint)) > 1000000 OR SUM(movie.runtime) > 120 ORDER BY movies_per_genre;')
rows = cursor.fetchall()
x = [rows[i][0] for i in range(len(rows))]
y = [rows[i][1] for i in range(len(rows))]

plt.suptitle('Movies per genre (erotima 2)')
plt.xlabel('genre')
plt.ylabel('moveis_per_genre')
plt.bar(x,y)
plt.show()

# erotima 3
cursor.execute('SELECT genre.name, YEAR(release_date) as year, COUNT(movie.id) as movies_per_gy FROM genre, movie, hasGenre WHERE movie.id = hasGenre.movie_id AND genre.id = hasGenre.genre_id AND YEAR(release_date) IS NOT NULL GROUP BY genre.name, YEAR(release_date) ORDER BY genre.name;')
rows = cursor.fetchall()
x = [rows[i][0] for i in range(len(rows))]
y = [rows[i][1] for i in range(len(rows))]
z = [rows[i][2] for i in range(len(rows))]

# Initializing Figure
fig = plt.figure()
ax1 = fig.add_subplot(111, projection='3d')
ax1.set_facecolor((1.0, 1.0, 1.0))

# Creating a dictionary from categories to x-axis coordinates
xCategories = x
i=0
xDict = {}
x1=[]
for category in xCategories:
  if category not in xDict:
    xDict[category]=i
    x1.append(i)
    i+=1
  else:
    x1.append(xDict[category])

# Defining the starting position of each bar (x is already defined)
z1 = np.zeros(len(x1))
# Defining the length/width/height of each bar.
dx = np.ones(len(x1))*0.01
dy = np.ones(len(x1))
dz = z

ax1.bar3d(x1, y, z1, dx, dy, dz)

plt.suptitle('Number of movies released per year for each genre (erotima 3)')
plt.xticks(range(len(xDict.values())), xDict.keys())
plt.show()

# erotima 4
cursor.execute('SELECT YEAR(release_date) as year, SUM(CAST( movie.revenue AS bigint)) as revenues_per_year FROM movie, movie_cast WHERE movie.id = movie_cast.movie_id AND YEAR(release_date) IS NOT NULL AND revenue IS NOT NULL AND name = \'CILLIAN MURPHY\' GROUP BY YEAR(release_date) ORDER BY YEAR(release_date);')
rows = cursor.fetchall()
x = [rows[i][0] for i in range(len(rows))]
y = [rows[i][1] for i in range(len(rows))]

plt.suptitle('Revenues per year for Cillian Mutphy (erotima 4)')
plt.xlabel('year')
plt.ylabel('revenues_per_year')
plt.bar(x,y)
plt.show()

# erotima 5
cursor.execute('SELECT YEAR(release_date) as year, MAX(movie.budget) as max_budget FROM movie WHERE YEAR(release_date) IS NOT NULL AND budget > 0 GROUP BY YEAR(release_date) ORDER BY YEAR(release_date);')
rows = cursor.fetchall()
x = [rows[i][0] for i in range(len(rows))]
y = [rows[i][1] for i in range(len(rows))]

plt.suptitle('Max budget per year (erotima 5)')
plt.xlabel('year')
plt.ylabel('max_budget')
plt.bar(x,y)
plt.show()

# erotima 7
cursor.execute('SELECT AVG(rating) as avg_rating, COUNT(rating) as rating_count FROM ratings GROUP BY user_id;')
rows = cursor.fetchall()
x = [rows[i][0] for i in range(len(rows))]
y = [rows[i][1] for i in range(len(rows))]

plt.suptitle('Average rating per user (erotima 7)')
plt.xlabel('avg_rating')
plt.ylabel('rating_count')
# plt.bar(x,y)
# plt.show()

plt.scatter(x, y,s=1)
plt.show()