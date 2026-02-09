# MovieLens Database Analysis & Implementation

This repository contains the complete set of academic assignments for the **Databases** course. The project centers on the design, implementation, optimization, and visualization of a relational database using the **MovieLens** dataset.

## Project Structure

### 1. Database Schema & Data Integration (Assignment 2)
The primary objective was to transform raw CSV data into a normalized relational schema.
* **Data Preprocessing:** Handled metadata for over 45,000 movies, including genres, production companies, and collections.
* **JSON Processing:** Developed Python parsers to extract nested JSON strings from `keywords.csv` to create the `keyword` and `hasKeyword` tables.
* **Schema Definition:** Created tables for `movie`, `genre`, `collection`, `production_company`, `movie_cast`, `movie_crew`, and `ratings`.
* **Integrity Constraints:** Implemented Primary Keys and Foreign Keys using `ALTER TABLE` commands to ensure referential integrity across the database.

### 2. Exploratory SQL Analysis (Assignment 3)
Explored the dataset through 12 complex SQL queries to extract cinematic insights.
* **SQL Operations:** Utilized `INNER JOIN`, `OUTER JOIN`, `GROUP BY`, and `HAVING` clauses.
* **Aggregation:** Performed statistical analysis using `AVG`, `MIN`, `MAX`, and `COUNT`.
* **Platform Specifics:** Adapted queries for Microsoft SQL Server, utilizing the `TOP` operator for result restriction.

### 3. ER Diagrams & Data Cleaning (Assignment 4)
Refined the database architecture and resolved real-world data inconsistencies.
* **ER Modeling:** Designed a comprehensive Entity-Relationship diagram showing movie connections to cast and crew (1:N relationships).
* **Data Integrity:** Used SQL scripts to remove duplicate records from junction tables (`hasGenre`, `hasKeyword`, etc.).
* **Views:** Implemented `Actor`, `CrewMember`, and `Person` views to unify metadata.
* **Anomalies:** Identified and corrected `person_id` inconsistencies where a single ID mapped to multiple names or genders.



### 4. Query Optimization & Triggers (Assignment 5)
Focused on performance tuning and automated data synchronization.
* **Execution Plans:** Analyzed query plans (Estimated vs. Actual) to identify performance bottlenecks like full table scans.
* **Indexing:** Created strategic indexes and covering indexes to optimize heavy queries on the `Ratings` and `Movie` tables.
* **Automation:** Developed an SQL `TRIGGER` that automatically updates a movie's `AVG_Rating` in the `movie` table whenever a new entry is added to `ratings`.

### 5. Data Visualization & Recommendations (Final Project)
The final phase involved deep data analysis and visual representation using Python.
* **Trend Analysis:** Visualized movies per year, budget distributions, and genre popularity.
* **Actor Analytics:** Calculated total revenue per actor across their entire filmography.
* **Recommendation Logic:** Developed a "Popular Movie Pairs" algorithm, identifying pairs of movies rated >4 by at least 10 common users.