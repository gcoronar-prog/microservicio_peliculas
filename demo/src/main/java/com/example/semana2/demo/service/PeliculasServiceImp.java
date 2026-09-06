package com.example.semana2.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.semana2.demo.models.Peliculas;
import com.example.semana2.demo.repository.PeliculasRepository;
import java.util.List;
import java.util.Optional;

@Service 
public class PeliculasServiceImp implements PeliculasService {
    @Autowired 
    private PeliculasRepository peliculasRepository;

    @Override 
    public List<Peliculas> getAllPeliculas(){
        return peliculasRepository.findAll();
    }

    @Override 
    public Optional<Peliculas> getPeliculaById(Long id){
        return peliculasRepository.findById((long) id);
    }
}
