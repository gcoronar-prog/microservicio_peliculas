package com.example.semana2.demo.service;

import com.example.semana2.demo.models.Peliculas;
import java.util.List;
import java.util.Optional;

public interface PeliculasService {//Interface del servicio de peliculas
    List<Peliculas> getAllPeliculas(); //Metodo para obtener los datos de las peliculas
    Optional<Peliculas> getPeliculaById(Long id);//Metodo para obtener los datos segun la id ingresada
    
}
