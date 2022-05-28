INSERT INTO film(movie_id,title,release,age_restriction,director_id,rate) VALUES (1,'Gladiator',2000,16,1,8.5)
INSERT INTO film(movie_id,title,release,age_restriction,director_id,rate) VALUES (2,'Prisoners',2013,16,2,8.1)
INSERT INTO film(movie_id,title,release,age_restriction,director_id,rate) VALUES (2,'A Bronx Tale',1993,16,3,7.8)

INSERT INTO genre(genre_id,name) VALUES (1,'Akció, Kaland')
INSERT INTO genre(genre_id,name) VALUES (2,'Krimi, Dráma')
INSERT INTO genre(genre_id,name) VALUES (3,'Krimi, Filmdráma')

INSERT INTO user(user_id,first_name,last_name,password,email) VALUES (1,'Serpenyőfejű','Bendegúz','excercisebook12','serpenyofeju.bendeguz@gmail.com')
INSERT INTO user(user_id,first_name,last_name,password,email) VALUES (2,'István','Nagy','ilikeicecream1','nagy.istvan@gmail.com')
INSERT INTO user(user_id,first_name,last_name,password,email) VALUES (3,'Dezső','Kolompár','xxx420xxx','kolompar.dezso@gmail.com')

INSERT INTO actor(actor_id,name,birth_date,image_name) VALUES (1,'Russel Crowe','1964-04-07','russel_crowe_image')
INSERT INTO actor(actor_id,name,birth_date,image_name) VALUES (2,'Hugh Jackman','1968-10-12','hugh_jackman_image')
INSERT INTO actor(actor_id,name,birth_date,image_name) VALUES (3,'Robert De Niro','1943-08-17','robert_de_niro_image')

INSERT INTO director(director_id,name) VALUES (1,'Ridley Scott')
INSERT INTO director(director_id,name) VALUES (2,'Denis Villeneuve')
INSERT INTO director(director_id,name) VALUES (3,'Robert De Niro')

INSERT INTO genre_in_movie(movie_id,genre_id) VALUES (1,1)
INSERT INTO genre_in_movie(movie_id,genre_id) VALUES (2,2)
INSERT INTO genre_in_movie(movie_id,genre_id) VALUES (3,3)

INSERT INTO actor_in_movie(movie_id,actor_id) VALUES (1,1)
INSERT INTO actor_in_movie(movie_id,actor_id) VALUES (2,2)
INSERT INTO actor_in_movie(movie_id,actor_id) VALUES (3,3)