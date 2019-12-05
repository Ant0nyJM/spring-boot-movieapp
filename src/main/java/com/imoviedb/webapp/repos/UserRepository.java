package com.imoviedb.webapp.repos;

import com.imoviedb.webapp.models.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<ApplicationUser, String> {

    ApplicationUser findByUsername(String username);

}
