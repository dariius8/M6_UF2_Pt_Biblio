CREATE DATABASE IF NOT EXISTS Biblio;

CREATE TABLE IF NOT EXISTS Biblioteca
(
	id_biblioteca integer(11) PRIMARY KEY, 
	nom varchar(15)
);
CREATE TABLE IF NOT EXISTS Persona
(
	dni varchar(9) PRIMARY KEY, 
	nom_persona varchar(15), 
	telefon integer(9)
);
CREATE TABLE IF NOT EXISTS Autor
(
	id_autor integer(11) PRIMARY KEY, 
	nom_autor varchar(15)
);
CREATE TABLE IF NOT EXISTS Llibres
(
	id_llibre integer(11) PRIMARY KEY, 
	nom_llibre varchar(15), 
	editoria varchar(15),
	autor integer(11),
	FOREIGN KEY (autor) REFERENCES Autor(id_autor)
);