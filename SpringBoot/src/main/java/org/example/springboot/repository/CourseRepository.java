package org.example.springboot.repository;

import org.example.springboot.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {


    List<Course> findByAuthorsId(Long author_id);

    List<Course> findCoursesByAuthorsId(Long author_id);




}
