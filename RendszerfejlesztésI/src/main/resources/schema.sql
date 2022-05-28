DROP TABLE IF EXISTS ;
 
CREATE TABLE film (
    movie_id SERIAL PRIMARY KEY,
    title varchar(100) NOT NULL,
    release INT NOT NULL,
    age_restriction INT,
    director_id INT,
    rate FLOAT 
);
CREATE TABLE genre (
    genre_id INT PRIMARY KEY,
    name varchar(10) NOT NULL,
);
CREATE TABLE user (
    user_id SERIAL PRIMARY KEY ,
    first_name varchar (50) NOT NULL,
    last_name varchar (50) NOT NULL,
    password varchar (50) NOT NULL,
    email TEXT NOT NULL
);
CREATE TABLE actor(
    actor_id INT PRIMARY KEY,
    name varchar (100) NOT NULL,
    birth_date DATE NOT NULL,
    image_name varchar (50) NOT NULL
);
CREATE TABLE director(
    director_id SERIAL PRIMARY KEY,
    name varchar (100) NOT NULL
);

CREATE TABLE genre_in_movie(
    movie_id INT,
    genre_id INT,
    PRIMARY KEY (movie_id, genre_id)
);
CREATE TABLE actor_in_movie(
    movie_id INT,
    actor_id INT,
    PRIMARY KEY (movie_id,actor_id)
);


