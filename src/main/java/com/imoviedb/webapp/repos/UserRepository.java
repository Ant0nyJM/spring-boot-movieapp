package com.imoviedb.webapp.repos;

import com.imoviedb.webapp.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {


}
