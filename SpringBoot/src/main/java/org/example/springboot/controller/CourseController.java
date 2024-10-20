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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    CourseController(CourseService courseService) {
        // @Autowired
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse>  createCourse(@RequestBody CourseDto courseDto) {

        try {

            courseService.addCourseWithSections(courseDto);
            return  ResponseEntity.ok( new ApiResponse( "Course Created Successfully",null));
        } catch ( Exception e ) {
            return  ResponseEntity.badRequest().body(new ApiResponse("An error occured", null));
        }




    }

    @GetMapping
    public ResponseEntity< ApiResponse> getCourses(){

        try{
            List<Course> co=courseService.getCourses();

            return  ResponseEntity.ok( new ApiResponse("Courses Fetched Successfully" , co));

//            Map<String,List<Course>> res= new HashMap<>();
//            res.put( "data" , co );
//            return ResponseEntity.ok( res);
//            //return  res;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
