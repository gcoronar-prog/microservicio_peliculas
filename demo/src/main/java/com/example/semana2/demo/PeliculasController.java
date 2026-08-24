package com.example.semana2.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeliculasController {
    private List<Peliculas> peliculas = new ArrayList<>();

    public PeliculasController() {
       peliculas.add(new Peliculas(1, "Interstellar", "Christopher Nolan", 2014, "Ciencia ficción",
        "Un grupo de exploradores atraviesa un agujero de gusano en busca de un nuevo hogar para la humanidad."));

        peliculas.add(new Peliculas(2, "El Padrino", "Francis Ford Coppola", 1972, "Drama",
                "El hijo menor de una familia mafiosa asume el poder que siempre quiso evitar."));

        peliculas.add(new Peliculas(3, "Parásitos", "Bong Joon-ho", 2019, "Suspenso",
                "Una familia sin recursos se infiltra poco a poco en el hogar de una familia adinerada."));

        peliculas.add(new Peliculas(4, "Mad Max: Furia en la carretera", "George Miller", 2015, "Acción",
                "En un desierto postapocalíptico, una fugitiva y un sobreviviente huyen de un tirano."));

        peliculas.add(new Peliculas(5, "Coco", "Lee Unkrich", 2017, "Animación",
                "Un niño llega a la Tierra de los Muertos y descubre el secreto musical de su familia."));

        peliculas.add(new Peliculas(6, "El Laberinto del Fauno", "Guillermo del Toro", 2006, "Fantasía",
                "Una niña en la posguerra española escapa a un mundo mágico gobernado por un fauno."));
            }

    @GetMapping("/peliculas")
    public List<Peliculas> getPeliculas() {
        return peliculas;
    }

    @GetMapping("/peliculas/{id}")
    public Peliculas getPeliculaById(@PathVariable int id) {
        for (Peliculas pelicula : peliculas){
            if(pelicula.getId() == id){
                return pelicula;
            }
        }
        return null;
    }
}