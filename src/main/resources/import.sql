CREATE TABLE author (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE album(
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    created_at TIMESTAMP,
    author_id INT,
    FOREIGN KEY (author_id) REFERENCES author(id)
);



insert into author (id, name) values (1, 'Monuments');
insert into author (id, name) values (2, 'Dire Straits');
insert into album(id, name, created_at, author_id) values (1, 'Nefarious', '2018-12-10 08:00:00', 1);
insert into album(id, name, created_at, author_id) values (2, 'In Statis','2018-12-10 12:34:00', 1);
insert into album(id, name, created_at, author_id) values (3, 'Making Movies', '2017-12-10 09:00:00', 2);
insert into album(id, name, created_at, author_id) values (4, 'Brothers in Arms', '2018-12-10 15:30:00' , 2);

