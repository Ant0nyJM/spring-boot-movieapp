package com.imoviedb.webapp.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.imoviedb.webapp.error.ObjectNotFoundException;
import com.imoviedb.webapp.models.Movie;
import com.imoviedb.webapp.repos.MovieRespository;
import com.imoviedb.webapp.service.MovieService;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;


@RestController
public class MovieController {
    @Autowired
    private MovieRespository movieRepository;

    @Autowired
    private MovieService movieService;

    @PostMapping("/movie/create")
    public Movie createMovie(@RequestBody Movie movie){

        return movieRepository.save(movie);
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<>(movieRepository.getAllMovies(),HttpStatus.OK);
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable("id") int id){
        Optional opt = movieRepository.findById(id);
        if(opt.isPresent()){
            return new ResponseEntity<>((Movie)opt.get(),HttpStatus.OK);
        }
        else{
            throw new ObjectNotFoundException("Obj not found");
        }

    }

    @PutMapping("/movie/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") int id, @RequestBody Movie movie){

        Movie updatedMovie = movieService.updateMovie(id,movie);
        return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
    }

    @DeleteMapping("/movie/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable int id){
        try {
            movieRepository.deleteById(id);
            return new ResponseEntity<>("Movie Deleted",HttpStatus.OK);
        }
        catch(EmptyResultDataAccessException e){
            throw new ObjectNotFoundException("Movie not found.");
        }
    }


}
