package org.example.springboot.controller;

import org.example.springboot.Dtos.ApiResponse;
import org.example.springboot.Dtos.CourseDto;
import org.example.springboot.Dtos.LectureDto;
import org.example.springboot.Dtos.SectionDto;
import org.example.springboot.model.Course;
import org.example.springboot.model.Lecture;
import org.example.springboot.model.Resource;
import org.example.springboot.model.Section;
import org.example.springboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
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
    public ResponseEntity<ApiResponse>   CreateCourse(@RequestBody CourseDto courseDto) {

        try {
            Course course = new Course();
            course.setTitle(courseDto.getTitle());
            course.setDescription(courseDto.getDescription());
course.setCourseLevel(courseDto.getCourseLevel());
            List<Section> sections = new ArrayList<>();

            for( SectionDto sectionDto : courseDto.getSections()){

                System.out.println("sectioon DTO is" + sectionDto);
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
            System.out.println(courseDto.toString());
            System.out.println("Couse object details" +  course.toString());
            // return
            courseService.addCourseWithSections(course);

            return  ResponseEntity.ok( new ApiResponse( "Course Created Successfully",courseDto));
        } catch ( Exception e ) {
            return  ResponseEntity.badRequest().body(new ApiResponse("An error occured", null));
        }




    }



}
