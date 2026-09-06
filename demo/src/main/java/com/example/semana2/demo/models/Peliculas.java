package com.example.semana2.demo.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import jakarta.validation.constraints.*;

@Entity
@Table(name = "peliculas")
public class Peliculas {
    //id, titulo, año, director, género y sinopsis.
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "director")
    private String director;
    @Column(name = "anio")
    private int anio;
    @Column(name = "género")
    private String género;
    @Column(name = "sinopsis")
    private String sinopsis;
  
    public Peliculas(int id, String nombre, String director, int anio, String género, String sinopsis) {
        this.id = id;
        this.nombre = nombre;
        this.director = director;
        this.anio = anio;
        this.género = género;
        this.sinopsis = sinopsis;
    }

    //Getter
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDirector() {
        return director;
    }
    public int getAnio() {
        return anio;
    }
    public String getGénero() {
        return género;
    }
    public String getSinopsis() {
        return sinopsis;
    }
}
