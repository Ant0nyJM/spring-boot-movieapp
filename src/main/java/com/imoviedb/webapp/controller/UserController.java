package com.imoviedb.webapp.controller;


import com.imoviedb.webapp.error.UserAlreadyExistsException;
import com.imoviedb.webapp.models.ApplicationUser;
import com.imoviedb.webapp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;



    @PostMapping("/register")
    public ResponseEntity<HashMap<String,String>> registerUser(@RequestBody ApplicationUser user){

        ApplicationUser checkUser = userRepository.findByUsername(user.getUsername());
        if(checkUser == null){
            userRepository.save(user);
            HashMap<String,String> resp = new HashMap<>();
            resp.put("message","User has been created");
            return new ResponseEntity<>(resp, HttpStatus.OK);
        }
        else{
            throw new UserAlreadyExistsException(checkUser.getUsername());
        }

    }


    @GetMapping("/users")
    public ResponseEntity<List<ApplicationUser>> getAllUsers(){
        return new ResponseEntity<>(userRepository.getAllUsers(),HttpStatus.OK);

    }
}
