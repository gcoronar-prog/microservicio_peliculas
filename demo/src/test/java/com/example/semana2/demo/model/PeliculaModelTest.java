package com.example.semana2.demo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.semana2.demo.models.Peliculas;

class PeliculaModelTest {
    @Test 
    void testGetterAndSetters(){
        Peliculas pelicula = new Peliculas();
        pelicula.setId(1L);
        pelicula.setAnio(2026);
        pelicula.setDirector("Director de prueba");
        pelicula.setGenero("Genero de prueba");
        pelicula.setTitulo("Titulo de prueba");
        pelicula.setSinopsis("sinopsis de prueba");
        assertEquals(1L, pelicula.getId());
        assertEquals(2026, pelicula.getAnio());
        assertEquals("Director de prueba", pelicula.getDirector());
        assertEquals("Genero de prueba", pelicula.getGenero());
        assertEquals("Titulo de prueba", pelicula.getTitulo());
        assertEquals("sinopsis de prueba", pelicula.getSinopsis());


    }
}
