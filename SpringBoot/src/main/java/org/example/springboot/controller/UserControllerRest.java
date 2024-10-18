package org.example.springboot.controller;


import org.example.springboot.model.User;
import org.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerRest {


    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public User addUser( @RequestBody  User user) {
        return  userService.save(user);
    }

}
