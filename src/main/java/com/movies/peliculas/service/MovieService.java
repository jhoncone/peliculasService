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
public Movie update(Long id, Movie movie){
        Optional<Movie>  movieData=movieRepository.findById(id);

        if(movieData.isPresent()){
            Movie _movie=movieData.get();
            _movie.setTitle(movie.getTitle());
            _movie.setSinopsis(movie.getSinopsis());
            _movie.setLanguage(movie.getLanguage());
            _movie.setReleased(movie.getReleased());
            return movieRepository.save(_movie);
        }
        else {
            return movie;

        }


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
