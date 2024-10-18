package org.example.springboot.service;


import org.example.springboot.model.User;
import org.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class UserService {

   // @Autowired
    private final UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Optional<User> login(String email, String password) {

        return userRepository.findByEmailAndPassword(email, password);
    }


    public User save(@Valid  User user) {
       return userRepository.save(user);
    }

    public void sample(){
        System.out.println("hi");
    }

}
