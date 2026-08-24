package com.example.semana2.demo;


public class Peliculas {
    //id, titulo, año, director, género y sinopsis.
    private int id;
    private String nombre;
    private String director;
    private int año;
    private String género;
    private String sinopsis;
  
    public Peliculas(int id, String nombre, String director, int año, String género, String sinopsis) {
        this.id = id;
        this.nombre = nombre;
        this.director = director;
        this.año = año;
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
    public int getAño() {
        return año;
    }
    public String getGénero() {
        return género;
    }
    public String getSinopsis() {
        return sinopsis;
    }
}
