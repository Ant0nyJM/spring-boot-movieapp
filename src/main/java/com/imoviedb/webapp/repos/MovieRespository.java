package com.imoviedb.webapp.repos;

import com.imoviedb.webapp.models.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRespository extends CrudRepository<Movie, String> {

    @Query(value = "select * from movieapp_motionpicture", nativeQuery = true)
    public List<Movie> getAllMovies();
}
