package com.imoviedb.webapp.service.interfaces;

import com.imoviedb.webapp.models.Movie;
import org.springframework.stereotype.Service;

public interface IMovieService {

    Movie updateMovie(String id, Movie newMovie);

}
