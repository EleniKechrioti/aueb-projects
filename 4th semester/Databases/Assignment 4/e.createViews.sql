CREATE VIEW Actor AS
SELECT distinct person_id, gender, name
FROM movie_cast

CREATE VIEW CrewMember AS
SELECT distinct person_id,gender,name
FROM movie_crew

CREATE VIEW Person AS
SELECT person_id, gender, name
FROM Actor
UNION 
SELECT  person_id,gender, name
FROM CrewMember

SELECT person_id
FROM Person
GROUP BY person_id
HAVING (COUNT(DISTINCT Person.name) > 1 or COUNT(DISTINCT gender)>1) or COUNT(DISTINCT person_id) > 1;