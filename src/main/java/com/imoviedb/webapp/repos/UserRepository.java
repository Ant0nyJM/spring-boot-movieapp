package com.imoviedb.webapp.repos;

import com.imoviedb.webapp.models.ApplicationUser;
import com.imoviedb.webapp.models.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<ApplicationUser, String> {

    ApplicationUser findByUsername(String username);

    @Query(value = "select * from auth_user", nativeQuery = true)
    public List<ApplicationUser> getAllUsers();
}
