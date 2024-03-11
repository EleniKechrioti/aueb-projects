-- 1
SELECT YEAR(release_date) as year1, COUNT(id) as movies_per_year
FROM movie
WHERE release_date is not null and budget is not null
GROUP BY YEAR(release_date)
HAVING SUM(CAST( budget AS bigint)) > 1000000
ORDER BY year1;

-- 2
SELECT genre.name, COUNT(movie.id) as movies_per_genre
FROM movie, genre, hasGenre
WHERE movie.id = hasGenre.movie_id AND genre.id = hasGenre.genre_id
GROUP BY genre.name
HAVING SUM(CAST( budget AS bigint)) > 1000000 OR SUM(movie.runtime) > 120
ORDER BY movies_per_genre;

-- 3
SELECT genre.name, YEAR(release_date) as year, COUNT(movie.id) as movies_per_gy
FROM genre, movie, hasGenre
WHERE movie.id = hasGenre.movie_id AND genre.id = hasGenre.genre_id AND YEAR(release_date) IS NOT NULL
GROUP BY genre.name, YEAR(release_date)
ORDER BY genre.name;

-- 4
SELECT YEAR(release_date) as year, SUM(CAST( movie.revenue AS bigint)) as revenues_per_year
FROM movie, movie_cast
WHERE movie.id = movie_cast.movie_id AND YEAR(release_date) IS NOT NULL AND revenue IS NOT NULL AND name = 'CILLIAN MURPHY'
GROUP BY YEAR(release_date)
ORDER BY YEAR(release_date);

-- 5
SELECT YEAR(release_date) as year, MAX(movie.budget) as max_budget
FROM movie
WHERE YEAR(release_date) IS NOT NULL AND budget > 0
GROUP BY YEAR(release_date)
ORDER BY YEAR(release_date);

-- 6
SELECT collection.name as trilogy_name
FROM collection, belongsTocollection
WHERE collection.id = belongsTocollection.collection_id
GROUP BY collection.name
HAVING COUNT(movie_id) = 3;

-- 7
SELECT AVG(rating) as avg_rating, COUNT(rating) as rating_count
FROM ratings
GROUP BY user_id;

-- 8
SELECT TOP(10) title as movie_title, budget
FROM movie
ORDER BY budget DESC;

-- 9
SELECT YEAR(release_date) as year, movie.title as movies_with_max_budget
FROM movie
WHERE  EXISTS (
    SELECT YEAR(release_date) as year , MAX(movie.budget) as budget
    FROM movie
    WHERE release_date IS NOT NULL AND budget > 0
    GROUP BY YEAR(release_date)
) AND release_date IS NOT NULL 
GROUP BY YEAR(release_date), movie.title
ORDER BY year;

-- 10
CREATE VIEW Popular_Movie_Pairs AS
SELECT r1.movie_id AS movie1, r2.movie_id AS movie2, COUNT(r1.user_id) AS pair_popularity
FROM ratings r1 
-- r1.movie_id != r2.movie_id Αν θέλουμε να μην έχουμε π.χ. τις ταινίες 1, 2 και 2, 1 r1.movie_id != r2.movie_id και r1.movie_id < r2.movie_id αν θέλουμε να έχουμε μόνο το ένα από τους δύο
JOIN ratings r2 ON r1.user_id = r2.user_id AND r1.movie_id < r2.movie_id
WHERE r2.rating > 4 AND r1.rating > 4
GROUP BY r1.movie_id, r2.movie_id
HAVING COUNT(r2.user_id) > 10;
