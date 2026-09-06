package com.example.semana2.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.semana2.demo.models.Peliculas;

public interface PeliculasRepository extends JpaRepository<Peliculas,Long>{
    
}
