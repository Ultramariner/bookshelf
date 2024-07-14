insert into genres (name) values ('genre1'),('genre2'),('genre3');
insert into books (name, short_name, rating, create_date) values ('book1', 'book1', 10, '01.01.2001'),('book2', 'book2', 20, '01.01.2002'),('book3', 'book3', 30, '01.01.2003'),('book4', 'book4', 40, '01.01.2004'),('book5', 'book5', 50, '01.01.2005');
insert into books_genres (book_id, genres_id) VALUES (1,1),(1,2),(2,2),(2,3),(3,3),(3,1),(4,2),(5,3);
insert into users (login, name, password) values ('login1','user1','password1'),('login2','user2','password2'),('login3','user3','password3');