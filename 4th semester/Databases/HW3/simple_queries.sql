-- /* Βρές όλες τις ταινίες που στον τίτλο περιέχεται η λέξη "puppet" 
-- Rows: 27
-- */
-- SELECT movie.id, original_title
-- FROM movie
-- INNER JOIN haskeyword on movie.id = haskeyword.movie_id
-- INNER JOIN keywords on  haskeyword.keyword_id = keywords.id
-- WHERE  keywords.name = 'puppet';

-- /* Βρές όλες τις ταινίες με μέσο όρο βαθμολογίας πάνω από 4 
-- ROWS: 46
-- */
-- SELECT movie.title, avg(ratings.rating) as avgRating
-- FROM movie
-- INNER JOIN ratings
-- ON movie.id = ratings.movie_id
-- GROUP BY movie.id, movie.title
-- HAVING avg(ratings.rating) > 4.5;


/* Βρές όλες τις ταινίες με genre = "Crime" και διάρκεια μεγαλύτερη από 90
ROWS: 1925
*/
SELECT movie.id, original_title
FROM movie, genre
INNER JOIN ratings on movie.id = ratings.movie_id AND genre.id = ratings.movie_id
WHERE  name = 'Crime' and runtime <90 and rating > 4.5;


-- /* Βρές όλες τις ταινίες με το genre που έχει id = 80
-- ROWS: 1285
-- */
-- SELECT movie.id, original_title
-- FROM movie
-- INNER JOIN hasGenre on movie.id = hasGenre.movie_id
-- WHERE hasGenre.genre_id = 80;

-- /* Βρές όλες τις ταινίες όπου στο cast υπάρχει η Alicia Witt 
-- ROWS: 10
-- */
-- SELECT TOP(10) movie.id, original_title, movie_cast.name
-- FROM movie
-- INNER JOIN movie_cast on movie.id = movie_cast.movie_id
-- where movie_cast.name ='Alicia Witt';

-- /* Βρές όλες τις ταινίες που ανοίκουν στην συλλογή Star Trek
-- ROWS: 4
-- */
-- SELECT movie.id, belongsTocollection.movie_id
-- FROM movie
-- FULL OUTER JOIN belongsTocollection
-- ON movie.id = belongsTocollection.movie_id
-- WHERE belongsTocollection.collection_id = 115570;

-- /* Βρές την ταινία με τα περισσότερα κέρδη
-- ROWS: 1 */
-- SELECT MAX(revenue) as MaxRevenue
-- FROM movie;

-- /* Βρές την ταινία με τη μικρότερη χρονική διάρκεια
-- ROWS: 1 */
-- SELECT MIN(runtime) as MinRuntime
-- FROM movie
-- WHERE runtime IS NOT NULL;

-- /* Βρές τις ταινίες από το 2010 μέχρι το 2020
-- ROWS: 8
-- */
-- SELECT release_date
-- FROM movie
-- WHERE release_date BETWEEN '2010-01-01' AND '2020-01-01';

-- /* Ταξινόμησε σε φθίνουσα τις πρώτες 15 ταινίες με βάση την διασημότητα
-- ROWS 15 */
-- SELECT TOP(15) popularity
-- FROM movie
-- ORDER BY popularity DESC;

-- /* Βρές όλες τις ταινίες όπου ο τίτλος τους ξεκινάει με STAR */
-- SELECT title
-- FROM movie
-- WHERE title LIKE 'STAR%';

-- /* Βρές τις ταινίες στις οποίες ο σκηνοθέτης είναι ο Stephen Hopkins
-- ROWS: 8 
-- */
-- SELECT movie.id, title
-- from movie
-- INNER join movie_crew on movie.id = movie_crew.movie_id
-- where movie_crew.job = 'Director' and movie_crew.name = 'Stephen Hopkins'