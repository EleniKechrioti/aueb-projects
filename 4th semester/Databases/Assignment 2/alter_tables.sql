ALTER TABLE movie
    ADD CONSTRAINT movie_pk
    PRIMARY KEY (id);

ALTER TABLE genre
    ADD CONSTRAINT genre_pk
    PRIMARY KEY (id);

ALTER TABLE productioncompany
    ADD CONSTRAINT productioncompany_pk
    PRIMARY KEY (id);

ALTER TABLE collection
    ADD CONSTRAINT collection_pk
    PRIMARY KEY (id);

ALTER TABLE movie_cast
    ADD CONSTRAINT movie_cast_pk
    PRIMARY KEY (cid);

ALTER TABLE movie_crew
    ADD CONSTRAINT movie_crew_pk
    PRIMARY KEY (cid);
    
ALTER TABLE keywords
    ADD CONSTRAINT keywords_pk
    PRIMARY KEY (id);

ALTER TABLE ratings
    ADD CONSTRAINT FK_movieid FOREIGN
KEY (movie_id)
    REFERENCES movie(id);

ALTER TABLE belongsTocollection
    ADD CONSTRAINT FK_collection_id FOREIGN
KEY (collection_id)
    REFERENCES collection(id);

ALTER TABLE belongsToCollection
    ADD CONSTRAINT FK_movie_collection FOREIGN
KEY (movie_id)
    REFERENCES movie(id);

ALTER TABLE hasGenre
    ADD CONSTRAINT FK_hasGenre FOREIGN
KEY (genre_id)
    REFERENCES genre(id);

ALTER TABLE hasGenre
    ADD CONSTRAINT FK_movie_genre FOREIGN
KEY (movie_id)
    REFERENCES movie(id);

ALTER TABLE hasProductionCompany
    ADD CONSTRAINT FK_hasProductionCompany FOREIGN
KEY (pc_id)
    REFERENCES productioncompany(id);

ALTER TABLE hasProductionCompany
    ADD CONSTRAINT FK_movie_pc FOREIGN
KEY (movie_id)
    REFERENCES movie(id);

ALTER TABLE movie_cast
    ADD CONSTRAINT FK_movie_cast FOREIGN
KEY (movie_id)
    REFERENCES movie(id);

ALTER TABLE movie_crew
    ADD CONSTRAINT FK_movie_crew FOREIGN
KEY (movie_id)
    REFERENCES movie(id);

ALTER TABLE hasKeyword
    ADD CONSTRAINT FK_hasKeyword FOREIGN
KEY (keyword_id)
    REFERENCES keywords(id);

ALTER TABLE hasKeyword
    ADD CONSTRAINT FK_movie_keyword FOREIGN
KEY (movie_id)
    REFERENCES movie(id);