// Cypher queries for football data analysis

// Query 1: League Statistics (Home Wins, Away Wins, Draws)
// Display league name, count of home/away wins and draws, sorted by league name

MATCH (c:Competition)<-[:PART_OF]-(g:Game)
RETURN c.name AS Competition_Name,
        SUM(CASE WHEN g.winner = 1 THEN 1 ELSE 0 END) AS Home_Wins,
        SUM(CASE WHEN g.winner = 2 THEN 1 ELSE 0 END) AS Away_Wins,
        SUM(CASE WHEN g.winner = 0 THEN 1 ELSE 0 END) AS Draws
ORDER BY Competition_Name ASC

// Query 2: Greek Super League Match Results
// Results for "Super League 1" sorted by date

MATCH (h:Team)-[:HOSTED]->(g:Game)-[:PART_OF]->(c:Competition {name: "super-league-1"})
MATCH (a:Team)-[:VISITED]->(g)
RETURN g.date AS Game_Date,
        h.teamName AS Home_Team,
        a.teamName AS Away_Team,
        g.homeGoals AS Home_Goals,
        g.awayGoals AS Away_Goals
ORDER BY g.date ASC

// Query 3: Transfers (Greek League to Foreign League & Vice-Versa)
// Players who played for both a Greek team and a foreign team in the same season

MATCH (p:Player)-[r1:PLAYED_IN]->(g1:Game)-[:PART_OF]->(c1:Competition {name: "super-league-1"})
MATCH (p)-[r2:PLAYED_IN]->(g2:Game)-[:PART_OF]->(c2:Competition)
WHERE c1 <> c2
RETURN DISTINCT p.name AS Player_Name,
        r1.team AS Greek_Team,
        r2.team AS Foreign_Team,
        c2.name AS Foreign_Competition
ORDER BY Greek_Team ASC

// Query 4: Top Scorer per Team
// Displays the leading goalscorer for each team in the premier league

MATCH (t:Team)-[:HOSTED|VISITED]->(g:Game)-[:PART_OF]->(c:Competition {name: "premier-liga"})
MATCH (p:Player)-[r:PLAYED_IN {team: t.teamName}]->(g)
WITH t, p, SUM(r.goals) AS Total_Goals
ORDER BY t.teamName, Total_Goals DESC
WITH t, COLLECT({player: p.name, goals: Total_Goals})[0] AS Top_Scorer
RETURN t.teamName AS Team, Top_Scorer.player AS Scorer, Top_Scorer.goals AS Goals
ORDER BY Goals DESC


// Query 5: Top 10 "Hard" Defenders (Cards received)
// Defenders ranked by total red and yellow cards in premier league

MATCH (p:Player {position: "Defender"})-[r:PLAYED_IN]->(g:Game)-[:PART_OF]->(c:Competition {name: "premier-liga"})
RETURN p.name AS Player_Name,
        r.team AS Team,
        SUM(r.redCards) AS Total_Red_Cards,
        SUM(r.yellowCards) AS Total_Yellow_Cards
ORDER BY Total_Red_Cards DESC, Total_Yellow_Cards DESC
LIMIT 10


// Query 6: Main Attacking Duo (Teammates)
// Two attacking players of Olympiacos who played together most

MATCH (p1:Player {position: "Attack"})-[rel:TEAMMATES]-(p2:Player {position: "Attack"})
MATCH (p1)-[r:PLAYED_IN]->(g:Game)
WHERE r.team = "Olympiacos Piraeus"
RETURN p1.name AS Player_1, p2.name AS Player_2, rel.games_together AS Matches
ORDER BY Matches DESC
LIMIT 1

// Query 7: Most Central Players
// Top 3 players of a team who played with the highest number of different teammates in Olympiacos

MATCH (p1:Player)-[:TEAMMATES]-(p2:Player)
MATCH (p1)-[r:PLAYED_IN]->(g:Game)
WHERE r.team = "Olympiacos Piraeus"
RETURN p1.name AS Player_Name, COUNT(DISTINCT p2) AS Total_Teammates
ORDER BY Total_Teammates DESC
LIMIT 3