
import ast

import csv
file = open(".\\dataset\\keywords.csv",encoding='utf8', errors = 'ignore')
csvreader = csv.reader(file)
header = next(csvreader)
print(header)

seen = []
rows = []
with open( "keywords.csv", "w", encoding = 'UTF-8', newline = '') as f1:

    writer1 = csv.writer(f1) 
    writer1.writerow(['id','name'])

    f2 = open("haskeyword.csv", 'w', newline = '')
    writer2 = csv.writer(f2, delimiter=',', quotechar='"', quoting=csv.QUOTE_MINIMAL)
    writer2.writerow(['movie_id','keyword_id'])

    for row in csvreader:
        if row not in rows:   
            rows.append(row)
            jsonString = row[1]
            data = ast.literal_eval(jsonString)
            for dt in data:
                if dt in seen: 
                    writer2.writerow([row[0],dt['id']])
                    continue
                writer2.writerow([row[0],dt['id']])
                seen.append(dt)
                r = [dt['id'],dt['name']]
                writer1.writerow(r)

file.close()
f2.close()
