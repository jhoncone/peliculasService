package com.movies.peliculas.controller;

import com.movies.peliculas.model.Movie;
import com.movies.peliculas.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping(path = "/create")
    public Movie guardar(@RequestBody Movie movie){
      return movieService.guardarMovie(movie);
    }
    @GetMapping(path = "/movies")
    public ArrayList<Movie> getMovies(){
        return movieService.obtenerMovies();
    }

    @GetMapping(path = "/movie/{id}")
    public Optional<Movie> getMovieById(@PathVariable("id") Long id){
        return movieService.obtenerporId(id);
    }

    @PutMapping("/update/{id}")
    public Movie updateMovie(@PathVariable("id") Long id, @RequestBody Movie movie){
       return movieService.update(id,movie);
    }


    @DeleteMapping(path = "/{id}")
    public String eliminarMovie(@PathVariable("id") Long id){
        boolean ok=movieService.eliminarMovie(id);
        if(ok){
            return "se elimino la pelicula con id"+id;

        }else {
            return "no se pudo eliminar la pelicula con id"+id;
        }
    }
}
