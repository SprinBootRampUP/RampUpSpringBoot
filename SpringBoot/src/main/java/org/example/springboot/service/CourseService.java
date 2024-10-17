package org.example.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.example.springboot.model.Course;
import org.example.springboot.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCoursesByAuthor(Long authorId) {
        return courseRepository.findByAuthorsId(authorId);
    }


    public void addCourseWithSections( Course course) {

      //  return
        //System.out.println("HIIIIIII"+course.toString());
        log.info("Hiiii", course.toString(),course.getSections().toString());
                courseRepository.save(course);


    }



}
