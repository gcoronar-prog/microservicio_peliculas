package com.example.semana2.demo.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.semana2.demo.controllers.PeliculasController;
import com.example.semana2.demo.models.Peliculas;
import com.example.semana2.demo.service.PeliculasService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


import tools.jackson.databind.ObjectMapper;

@WebMvcTest (PeliculasController.class)
class PeliculaControllerTest {
    
    @Autowired 
    private MockMvc mockMvc;

    @MockitoBean 
    private PeliculasService service;

    @Autowired 
    private ObjectMapper mapper;

    private Peliculas pelicula;

    @BeforeEach 
    void setUp(){
        pelicula = new Peliculas();
        pelicula.setId(1L); //asignacion de id
        pelicula.setAnio(2026); //asignacion de año
        pelicula.setDirector("Director de prueba"); //Asignacion de director
        pelicula.setGenero("prueba"); //asignacion de genero de pelicula
        pelicula.setTitulo("Titulo de prueba"); // titulo de la pelicula
        pelicula.setSinopsis("sinopsis de prueba");
    }

    @Test 
    void testGetAllPeliculas() throws Exception{
        when(service.getAllPeliculas()).thenReturn(Arrays.asList(pelicula));
        mockMvc.perform(get("/peliculas"))
        .andExpect(status().isOk())
        .andExpect(content()
        .json(mapper.writeValueAsString(Arrays.asList(pelicula))));
    }

    @Test 
    void testGetPeliculaById() throws Exception {
        when(service.getPeliculaById(1L)).thenReturn(Optional.of(pelicula));
        mockMvc.perform(get("/peliculas/1"))
            .andExpect(status().isOk())
            .andExpect(content().json(mapper.writeValueAsString(pelicula)));
    }

    @Test 
    void testCreatePelicula() throws Exception{
        when(service.createPelicula(any(Peliculas.class))).thenReturn(pelicula);
        mockMvc.perform(post("/peliculas")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(pelicula)))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().json(mapper.writeValueAsString(pelicula)));
    }

    @Test 
    void testUpdatePelicula() throws Exception{
        when(service.updatePelicula(eq(1L), any(Peliculas.class))).thenReturn(pelicula);
        mockMvc.perform(put("/peliculas/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content(mapper.writeValueAsString(pelicula)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json(mapper.writeValueAsString(pelicula)));
    }

    @Test 
    void testDeletePelicula() throws Exception{
        mockMvc.perform(delete("/peliculas/1"))
                .andExpect(status().isOk());
        verify(service).deletePelicula(1L);
    }
}
