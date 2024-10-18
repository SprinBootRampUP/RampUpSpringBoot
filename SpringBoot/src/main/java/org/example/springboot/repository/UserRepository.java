package org.example.springboot.repository;

import org.example.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
   // User findByEmailAndPassword(String email, String password);
   Optional<User> findByEmailAndPassword(String email, String password);


}
