package com.example.semana2.demo.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "peliculas")
public class Peliculas {
    //id, titulo, año, director, género y sinopsis.
    //atributos de la clase y asignacion con anotaciones para la base de datos
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_pelicula")
    private Long id;

    @NotBlank (message = "El titulo de la pelicula no puede estar en blanco")
    @Size (min = 2, max = 30, message = "El titulo de la pelicula debe contener entre 2 y 30 caracteres")
    @Column(name = "titulo")
    private String titulo;

    @NotBlank (message = "El nombre del director no puede estar en blanco")
    @Size (min = 4, max = 40, message = "El nombre del director debe contener entre 4 y 40 caracteres")    
    @Column(name = "director")
    private String director;

    @NotNull (message = "El año de la pelicula no puede estar en blanco")
    @Min (value = 1895, message = "El año de la pelicula debe ser mayor a 1895")
    @Max (value = 2026, message = "El año de la pelicula no puede ser mayor a 2026")
    @Pattern (regexp="^\\d+$",message = "Solo se aceptan numeros")
    @Column(name = "anio")
    private int anio;

    @NotBlank (message = "El genero de la pelicula no puede estar en blanco")
    @Size (min = 4, max = 20, message = "El genero de la pelicula debe contener entre 4 y 20 caracteres")    
    @Column(name = "genero")
    private String genero;

    @NotBlank (message = "El contenido de la sinopsis no puede estar en blanco")
    @Size (min = 30, max = 100, message = "El genero de la pelicula debe contener entre 30 a 100 caracteres")    
    @Column(name = "sinopsis")
    private String sinopsis;
  
  

    //Getters
    public Long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getDirector() {
        return director;
    }
    public int getAnio() {
        return anio;
    }
    public String getGenero() {
        return genero;
    }
    public String getSinopsis() {
        return sinopsis;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

}
