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
        return peliculasRepository.findAll(); //FindAll para obtener todos los datos de la tabla peliculas de la base de datos.
    }

    @Override 
    public Optional<Peliculas> getPeliculaById(Long id){
        return peliculasRepository.findById((Long) id); //FindById para obtener los datos de la tabla en base a la busqueda por id de pelicula
    }

    @Override 
    public Peliculas createPelicula(Peliculas pelicula){
        return peliculasRepository.save(pelicula); //save para guardar los datos de peliculas en la base de datos
    }

    @Override 
    public Peliculas updatePelicula (Long id, Peliculas pelicula){
        if(peliculasRepository.existsById(id)){ // se verifica que exista la pelicula a traves de la id
            pelicula.setId(id); // se asigna la id de la pelicula a actualizar
            return peliculasRepository.save(pelicula); // se guardan los datos actualizados en la base de datos
        }else{
            return null; //retorna null si no existe el id de la pelicula a actualizar
        }
    }

    @Override 
    public void deletePelicula(Long id){
        peliculasRepository.deleteById(id); //funcion para eliminar peliculas a traves de su id
    }
}
