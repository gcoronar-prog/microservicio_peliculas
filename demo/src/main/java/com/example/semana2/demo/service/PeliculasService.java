package com.example.semana2.demo.service;

import com.example.semana2.demo.models.Peliculas;
import java.util.List;
import java.util.Optional;

public interface PeliculasService {
    List<Peliculas> getAllPeliculas();
    Optional<Peliculas> getPeliculaById(Long id);
    
}
