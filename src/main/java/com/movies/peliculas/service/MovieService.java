package com.movies.peliculas.service;

import com.movies.peliculas.model.Movie;
import com.movies.peliculas.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public Movie guardarMovie(Movie movie){
       return movieRepository.save(movie);
    }

    public ArrayList<Movie> obtenerMovies(){
        return (ArrayList<Movie>) movieRepository.findAll();
    }

    public Optional<Movie> obtenerporId(Long id) {
     return movieRepository.findById(id);
    }

    public boolean eliminarMovie(Long id){
        try {
            movieRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;

        }
    }

}
