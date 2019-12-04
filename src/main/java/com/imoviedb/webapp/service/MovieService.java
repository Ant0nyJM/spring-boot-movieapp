package com.imoviedb.webapp.service;

import com.imoviedb.webapp.error.ObjectNotFoundException;
import com.imoviedb.webapp.models.Movie;
import com.imoviedb.webapp.repos.MovieRespository;
import com.imoviedb.webapp.service.interfaces.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService implements IMovieService {

    @Autowired
    MovieRespository movieRespository;

    public Movie updateMovie(int id, Movie newMovie){

        Optional<Movie> query = movieRespository.findById(id);
        Movie oldMovie;

        if(query.isPresent()){
            oldMovie = query.get();
        }
        else{
            throw new ObjectNotFoundException("Movie does not exist.");
        }

        if(newMovie.getName() == null){
            newMovie.setName(oldMovie.getName());
        }
        if(newMovie.getDescription() == null){
            newMovie.setDescription((oldMovie.getDescription()));
        }
        if(newMovie.getRelease_date() == null){
            newMovie.setRelease_date((oldMovie.getRelease_date()));
        }
        newMovie.setId(id);
        return movieRespository.save(newMovie);

    }
}
