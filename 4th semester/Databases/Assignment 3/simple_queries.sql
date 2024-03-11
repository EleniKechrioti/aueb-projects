/* Βρες όλες τις ταινίες που έχουν σχέση με "puppet" και εμφάνισε γενικές πληροφορίες για κάθε μια (τίτλος, γλώσσα, ημερομηνία, διάρκεια) 
Rows: 27
*/
SELECT original_title, original_language, release_date, runtime
FROM movie
INNER JOIN haskeyword on movie.id = haskeyword.movie_id
INNER JOIN keywords on  haskeyword.keyword_id = keywords.id
WHERE  keywords.name = 'puppet';

/* Βρες όλες τις ταινίες με μέσο όρο βαθμολογίας πάνω από 4.5 και εμφάνισε τους τίτλους τους και τη βαθμολογία κατά φθίνουσα σειρά
ROWS: 46
*/
SELECT movie.title, avg(ratings.rating) as Ratings
FROM movie
INNER JOIN ratings
ON movie.id = ratings.movie_id
GROUP BY movie.id, movie.title
HAVING avg(ratings.rating) > 4.5
ORDER BY Ratings DESC;


/* Βρες όλες τις ταινίες με genre = 80, δηλαδή "Crime" και διάρκεια μεγαλύτερη από 90 λεπτά
ROWS: 1109
Μετά την αφαίρεση διπλοτύπων της 4ης εργασίας έχει 1107 γραμμές
*/
SELECT title, release_date, runtime, homepage
FROM movie
INNER JOIN hasGenre on hasGenre.movie_id = movie.id
WHERE hasGenre.genre_id = 80 and runtime >=90
ORDER BY title;


/* Βρές όλες τις ταινίες όπου στο cast υπάρχει η Alicia Witt 
ROWS: 11
*/
SELECT original_title, original_language, release_date
FROM movie
INNER JOIN movie_cast on movie.id = movie_cast.movie_id
where movie_cast.name ='Alicia Witt';

/*Βρες όλες τις κατηγορίες ταινίων που υπάρχουν στην βάση
(για να ξέρω τι να επιλέξω από ταινίες)
ROWS 9
Χωρίς το DISTINCT βγαίνουν 12072 rows*/
SELECT DISTINCT genre.name
FROM genre
JOIN hasGenre on hasGenre.genre_id = genre.id;


/* Βρές όλες τις συλλογές ταινιών που έχουν στο όνομα τους τις λέξεις STAR TREK
ROWS: 11
*/
SELECT movie.title, collection.name
FROM movie
RIGHT OUTER JOIN belongsTocollection
ON movie.id = belongsTocollection.movie_id
FULL OUTER JOIN collection on collection.id = belongsTocollection.collection_id
WHERE collection.name LIKE 'STAR TREK%';


/*Εμφάνισε τις ταινίες και δίπλα τις εταιρίες παραγωγής τους
ROWS 19930
Μετά την αφαίρεση διπλοτύπων της 4ης εργασίας έχει 19892 γραμμές*/
Select productioncompany.name, movie.title
FROM hasProductioncompany
INNER JOIN productioncompany 
ON hasProductioncompany.pc_id = productioncompany.id
FULL OUTER JOIN movie on movie.id = hasProductioncompany.movie_id


/* Βρες την ταινία με τα περισσότερα κέρδη
ROWS: 1 */
SELECT  title, revenue
FROM movie
where revenue = (
    select max(revenue)
    from movie);

/* Βρες τις ταινίες με τη μικρότερη χρονική διάρκεια και εμφάνισε το τίτλο τους και τη χρονική διάρκεια.
ROWS: 2 */
SELECT title, runtime
FROM movie
WHERE runtime = (Select MIN(runtime) from movie where runtime IS NOT NULL  and  runtime>0);


/* Βρες όλες τις δραματικές ταινίες των τελευταίων 10 ετών, δηλαδή από το 2010 μέχρι το 2020
ROWS: 6
*/
SELECT movie.title, release_date
FROM movie
JOIN hasGenre on hasGenre.movie_id = movie.id
WHERE release_date BETWEEN '2010-01-01' AND '2020-01-01' AND hasGenre.genre_id = 18
GROUP BY release_date, movie.title;


/* Βρες τις 15 πιο δημοφιλής ταινίες δράσης και εμφάνισε το τίτλο, τη ημερομηνία κυκλοφορίας τους και τη δημοσιότητα που έλαβαν
ROWS: 15 
Χωρίς το TOP(15) είναι 1818*/
SELECT TOP(15)  title, release_date, popularity
FROM movie
JOIN hasGenre on hasGenre.movie_id= movie.id
WHERE hasGenre.genre_id = 28
ORDER BY popularity DESC;


/* Βρες όλες τις ταινίες όπου έχουν σαν λέξη κλειδή την λέξη "space". Δηλαδή σχετίζονται με το διάστημα
ROWS 139
Χωρίς DISTINCT είναι 237 γραμμές*/
SELECT DISTINCT title,original_language,homepage ,release_date
FROM movie
JOIN hasKeyword on haskeyword.movie_id = movie.id
JOIN keywords on keywords.id = haskeyword.keyword_id
WHERE keywords.name LIKE '%space%';


