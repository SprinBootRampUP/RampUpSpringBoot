package org.example.springboot.service;


import org.example.springboot.model.Author;
import org.example.springboot.model.Course;
import org.example.springboot.repository.AuthorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.springboot.repository.CourseRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class TestService {

    @Autowired
    private CourseRepository courseRespository;

    @Autowired
    private AuthorRespository authorRepository;

    public void addCourseAndAuthors() {

        Author author1 = new Author();
        author1.setFirstName("Sharan");
        author1.setLastName("v");
        author1.setEmail("mail.com");

        Author author2 = new Author();
        author2.setFirstName("Kumar");
        author2.setLastName("S");
        author2.setEmail("mail.com");

        Author author3 = new Author();
        author3.setFirstName("raju");
        author3.setLastName("A");
        author3.setEmail("mail.com");

        authorRepository.save(author1);
        authorRepository.save(author2);

        Course course1 = new Course();
        course1.setId(31L);
        course1.setTitle("course 1");
        course1.setDescription("Learn Spring Boot.");

        Course course2 = new Course();
        course2.setId(32L);
        course2.setTitle("Course 2");
        course2.setDescription("Learn2");


        Course course3 = new Course();
        course3.setId(33L);
        course3.setTitle("Course 3");
        course3.setDescription("Learn3");


        course1.setAuthors(Arrays.asList(author1, author2));
        course2.setAuthors(List.of(author2));
        course3.setAuthors(List.of(author2));

        author3.setCourses(Arrays.asList(course1, course2, course3));

        authorRepository.save(author3);
        courseRespository.save(course1);
        courseRespository.save(course2);
        courseRespository.save(course3);



    }
}
