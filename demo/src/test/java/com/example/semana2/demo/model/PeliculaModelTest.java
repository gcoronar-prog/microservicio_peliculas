package com.example.semana2.demo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.semana2.demo.models.Peliculas;

class PeliculaModelTest {
    @Test 
    //Test de getters y setters
    void testGetterAndSetters(){
        Peliculas pelicula = new Peliculas();
        pelicula.setId(1L); //asignacion de id
        pelicula.setAnio(2026); //asignacion de año
        pelicula.setDirector("Director de prueba"); //Asignacion de director
        pelicula.setGenero("Genero de prueba"); //asignacion de genero de pelicula
        pelicula.setTitulo("Titulo de prueba"); // titulo de la pelicula
        pelicula.setSinopsis("sinopsis de prueba"); // prueba de sinopsis de la pelicula
        
        assertEquals(1L, pelicula.getId());
        assertEquals(2026, pelicula.getAnio());
        assertEquals("Director de prueba", pelicula.getDirector());
        assertEquals("Genero de prueba", pelicula.getGenero());
        assertEquals("Titulo de prueba", pelicula.getTitulo());
        assertEquals("sinopsis de prueba", pelicula.getSinopsis());
    }
}
