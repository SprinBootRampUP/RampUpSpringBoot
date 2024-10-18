package org.example.springboot.service;


import org.example.springboot.model.User;
import org.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public boolean save(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return false;
        }
        userRepository.save(user);
        return true;
    }

    public void sample(){
        System.out.println("hi");
    }

}
