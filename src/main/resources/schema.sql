CREATE TABLE IF NOT exists cats
(
	id int IDENTITY NOT NULL PRIMARY KEY,
	name varchar(20) NOT NULL,
	type varchar(20) NOT null
);