package com.example.semana2.demo.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.semana2.demo.models.Peliculas;
import com.example.semana2.demo.service.PeliculasService;

@RestController
@RequestMapping ("/peliculas")
public class PeliculasController {
    @Autowired 
    private PeliculasService peliculaService;

    @GetMapping
    public List<Peliculas> getPeliculas() {
        return peliculaService.getAllPeliculas();
    }

    @GetMapping("/{id}")
    public Optional<Peliculas> getPeliculaById(@PathVariable Long id) {
       return peliculaService.getPeliculaById(id);
    }
}