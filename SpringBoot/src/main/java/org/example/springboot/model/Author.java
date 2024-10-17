package org.example.springboot.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String email;

@ManyToMany(mappedBy = "authors"  )
 private List<Course> courses;

}