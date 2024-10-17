package org.example.springboot.Dtos;


import java.util.List;

public class AuthorDto {


    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private List<CourseDto> courses;
}

