DROP TABLE peliculas; --DROP en caso de existir en la base de datos la tabla peliculas

CREATE USER USER_BD_PELI IDENTIFIED BY "ClaseFullStack1." -- Creacion de usuario
DEFAULT TABLESPACE DATA
TEMPORARY TABLESPACE TEMP
QUOTA UNLIMITED ON DATA;

GRANT CREATE SESSION, CONNECT, RESOURCE TO USER_BD_PELI;
ALTER USER USER_BD_PELI DEFAULT ROLE RESOURCE; 

-- Creacion de tabla de peliculas
CREATE TABLE peliculas (
    id_pelicula number(3) GENERATED ALWAYS AS IDENTITY
    MINVALUE 1
    MAXVALUE 999
    INCREMENT BY 1
    START WITH 1,
    titulo VARCHAR2(30) NOT NULL,
    anio NUMBER(4) NOT NULL,
    director VARCHAR2(40) NOT NULL,
    genero VARCHAR2(20) NOT NULL,
    sinopsis VARCHAR2(100) NOT NULL
);

ALTER TABLE peliculas ADD CONSTRAINT pk_pelicula PRIMARY KEY(id_pelicula); --Creacion de clave primaria

--Insercion de datos a la tabla peliculas
INSERT INTO peliculas (titulo, anio, director, genero, sinopsis) VALUES ('Interstellar',2014,'Christopher Nolan','Ciencia ficción','Un grupo de exploradores atraviesa un agujero de gusano en busca de un nuevo hogar para la humanidad');
INSERT INTO peliculas (titulo, anio, director, genero, sinopsis) VALUES ('El Padrino',1972,'Francis Ford Coppola','Drama','El hijo menor de una familia mafiosa asume el poder que siempre quiso evitar');
INSERT INTO peliculas (titulo, anio, director, genero, sinopsis) VALUES ('Parásitos',2019,'Bong Joon-ho','Suspenso','Una familia sin recursos se infiltra poco a poco en el hogar de una familia adinerada');
INSERT INTO peliculas (titulo, anio, director, genero, sinopsis) VALUES ('Mad Max: Furia en la carretera',2015,'George Miller','Ciencia ficción','En un desierto postapocalíptico, una fugitiva y un sobreviviente huyen de un tirano');
INSERT INTO peliculas (titulo, anio, director, genero, sinopsis) VALUES ('Coco',2017,'Lee Unkrich','Animación','Un niño llega a la Tierra de los Muertos y descubre el secreto musical de su familia');
INSERT INTO peliculas (titulo, anio, director, genero, sinopsis) VALUES ('El Laberinto del Fauno',2006,'Guillermo del Toro','Ciencia ficción','Una niña en la posguerra española escapa a un mundo mágico gobernado por un fauno');

COMMIT;

