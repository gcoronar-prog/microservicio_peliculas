package com.example.semana2.demo.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public List<Peliculas> getPeliculas() { //Endpoint para mostrar todas las peliculas de la BD
        return peliculaService.getAllPeliculas();
    }

    @GetMapping("/{id}")
    public Optional<Peliculas> getPeliculaById(@PathVariable Long id) { //Endpoint para mostrar las peliculas segun su id
       return peliculaService.getPeliculaById(id);
    }

    @PostMapping 
    public Peliculas creaPelicula(@RequestBody Peliculas pelicula){ //Endpoint para crear una nueva pelicula en la base de datos
        return peliculaService.createPelicula(pelicula);
    }

    @PutMapping("/{id}")
    public Peliculas updatePelicula(@PathVariable Long id, @RequestBody Peliculas pelicula){ //Endpoint para actualizar los datos de una pelicula segun su id
        return peliculaService.updatePelicula(id,pelicula);
    }

    @DeleteMapping ("/{id}")
    public void deletePelicula(@PathVariable  Long id){ //Endpoint para eliminar una pelicula segun su id
        peliculaService.deletePelicula(id);
    }
}