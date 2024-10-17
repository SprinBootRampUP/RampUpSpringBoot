package org.example.springboot.controller;

import org.example.springboot.Dtos.CourseDto;
import org.example.springboot.Dtos.LectureDto;
import org.example.springboot.Dtos.SectionDto;
import org.example.springboot.model.Course;
import org.example.springboot.model.Lecture;
import org.example.springboot.model.Resource;
import org.example.springboot.model.Section;
import org.example.springboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CourseController {

    private final CourseService courseService;

    @Autowired
    CourseController(CourseService courseService) {
        // @Autowired
        this.courseService = courseService;
    }

    @RequestMapping("/course")
    public void   CreateCourse(@RequestBody CourseDto courseDto) {

        Course course = new Course();
        course.setTitle(courseDto.getTitle());
        course.setDescription(courseDto.getDescription());

        List<Section> sections = new ArrayList<>();

        for( SectionDto sectionDto : courseDto.getSections()){
            Section section = new Section();
            section.setName(sectionDto.getName());
            section.setOrderNumber(sectionDto.getOrderNumber());
            section.setCourse(course);
            List<Lecture> lectures = new ArrayList<>();

            for( LectureDto lectureDto : sectionDto.getLectures()){

                Lecture lecture = new Lecture();
                lecture.setName(lectureDto.getName());

                Resource resource = new Resource();
                resource.setName(lectureDto.getResource().getName());
                resource.setUrl(lectureDto.getResource().getUrl());
                resource.setSize(lectureDto.getResource().getSize());

                lecture.setResource(resource);
                lecture.setSection(section);
                lectures.add(lecture);
            }
            section.setLectures(lectures);
            sections.add(section);

        }
           course.setSections(sections);

       // return
        courseService.addCourseWithSections(course);


    }



}
