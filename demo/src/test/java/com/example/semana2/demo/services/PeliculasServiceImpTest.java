package com.example.semana2.demo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.semana2.demo.models.Peliculas;
import com.example.semana2.demo.repository.PeliculasRepository;
import com.example.semana2.demo.service.PeliculasServiceImp;

@ExtendWith (MockitoExtension.class)
class PeliculasServiceImpTest {
    
    @Mock 
    private PeliculasRepository repository;

    @InjectMocks 
    private PeliculasServiceImp service;

    private Peliculas pelicula;

    @BeforeEach 
    void setUp(){
        Peliculas pelicula = new Peliculas();
        pelicula.setId(1L); //asignacion de id
        pelicula.setAnio(2026); //asignacion de año
        pelicula.setDirector("Director de prueba"); //Asignacion de director
        pelicula.setGenero("Genero de prueba"); //asignacion de genero de pelicula
        pelicula.setTitulo("Titulo de prueba"); // titulo de la pelicula
        pelicula.setSinopsis("sinopsis de prueba");
    }

    @Test 
    void testGetAllPeliculas(){
        List<Peliculas> expected = Arrays.asList(pelicula);
        when(repository.findAll()).thenReturn(expected);
        assertEquals(expected, service.getAllPeliculas());
    }

    @Test 
    void testGetPeliculaById(){
        when(repository.findById(1L)).thenReturn(Optional.of(pelicula));
        assertEquals(Optional.of(pelicula), service);
    }

    @Test 
    void testCreatePelicula(){
        when(repository.save(pelicula)).thenReturn(pelicula);
        assertEquals(pelicula, service.createPelicula(pelicula));
    }

    @Test 
    void testUpdatePeliculaExist(){
        when(repository.existsById(1L)).thenReturn(true);
        when(repository.save(pelicula)).thenReturn(pelicula);
        Peliculas result = service.updatePelicula(1L, pelicula);
        assertEquals(1L, pelicula.getId());
        assertEquals(pelicula, result);
        verify(repository).save(pelicula);
    }

    @Test 
    void testUpdatePeliculaNotExists(){
        when(repository.existsById(1L)).thenReturn(false);
        assertNull(service.updatePelicula(1L, pelicula));
        verify(repository, never()).save(any());
    }

    @Test 
    void testDeletePelicula(){
        service.deletePelicula(1L);
        verify(repository).deleteById(1L);
    }
}
