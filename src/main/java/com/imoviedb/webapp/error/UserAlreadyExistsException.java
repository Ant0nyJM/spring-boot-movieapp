package com.imoviedb.webapp.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(String exception) {
        super(exception);
    }
}
