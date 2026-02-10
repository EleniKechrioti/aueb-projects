// Script for graph creation and data ingestion

// Create Constraints for Efficiency and Uniqueness
// We ensure that each entity exists only once in the graph to maintain data integrity.
CREATE CONSTRAINT PlayerIDConstraint IF NOT EXISTS FOR (p:Player) REQUIRE p.playerID IS UNIQUE;
CREATE CONSTRAINT TeamNameConstraint IF NOT EXISTS FOR (t:Team) REQUIRE t.teamName IS UNIQUE;
CREATE CONSTRAINT GameIDConstraint IF NOT EXISTS FOR (g:Game) REQUIRE g.gameID IS UNIQUE;
CREATE CONSTRAINT CompetitionNameConstraint IF NOT EXISTS FOR (c:Competition) REQUIRE c.name IS UNIQUE;

// Loading Nodes
// Using MERGE to avoid duplication of information
LOAD CSV WITH HEADERS FROM 'https://www.dropbox.com/scl/fi/qsm1wqnevo9a7dtp923r7/FootBallData.csv?rlkey=cbytm7qhv4blsuju4zd41poyl&st=xtql3jaq&dl=1' AS row FIELDTERMINATOR ';'

// Creating Player nodes with static properties
MERGE (p:Player {playerID: toInteger(row.PlayerID)})
ON CREATE SET p.name = row.PlayerName, 
              p.position = row.Position, 
              p.birthDate = row.BirthDate

// Creating Team nodes
MERGE (t:Team {teamName: row.PlayerTeamName})

// Creating Competition nodes
MERGE (c:Competition {name: row.CompetitionName})
ON CREATE SET c.country = row.Country

// Creating Game nodes with match details
MERGE (g:Game {gameID: toInteger(row.GameID)})
ON CREATE SET g.date = row.GameDate, 
              g.homeGoals = toInteger(row.HomeGoals), 
              g.awayGoals = toInteger(row.AwayGoals), 
              g.winner = toInteger(row.Winner);

// Loading Relationships
// Connecting entities based on the logical requirements of the problem
LOAD CSV WITH HEADERS FROM 'https://www.dropbox.com/scl/fi/qsm1wqnevo9a7dtp923r7/FootBallData.csv?rlkey=cbytm7qhv4blsuju4zd41poyl&st=xtql3jaq&dl=1' AS row FIELDTERMINATOR ';'

MATCH (p:Player {playerID: toInteger(row.PlayerID)})
MATCH (g:Game {gameID: toInteger(row.GameID)})
MATCH (c:Competition {name: row.CompetitionName})
MATCH (h:Team {teamName: row.HomeTeamName})
MATCH (a:Team {teamName: row.AwayTeamName})

// Participation relationship: Store the player's team here to support transfers
MERGE (p)-[r:PLAYED_IN]->(g)
ON CREATE SET r.team = row.PlayerTeamName,
              r.minutes = toInteger(row.Minutes),
              r.goals = toInteger(row.Goals),
              r.assists = toInteger(row.Assists),
              r.yellowCards = toInteger(row.YellowCards),
              r.redCards = toInteger(row.RedCards)

// Connecting game to its competition
MERGE (g)-[:PART_OF]->(c)

// Connecting the teams that played in the match (Home/Away)
MERGE (h)-[:HOSTED]->(g)
MERGE (a)-[:VISITED]->(g);

// Creating TEAMMATES Relationship
// Linking players who played together for the same team in the same match
MATCH (p1:Player)-[r1:PLAYED_IN]->(g:Game)<-[r2:PLAYED_IN]-(p2:Player)
WHERE p1.playerID < p2.playerID AND r1.team = r2.team
MERGE (p1)-[rel:TEAMMATES]->(p2)
ON CREATE SET rel.games_together = 1
ON MATCH SET rel.games_together = rel.games_together + 1;