package org.example.springboot.controller;

import jakarta.validation.Valid;
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

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Inject
    private  CourseService courseService;

    @Autowired
    private CourseService ss;

//    @Autowired
//    CourseController(CourseService courseService) {
//        // @Autowired
//        this.courseService = courseService;
//    }

    @PostMapping
    public ResponseEntity<ApiResponse>  createCourse( @Valid @RequestBody CourseDto courseDto) {

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
            List<CourseDto> courses=courseService.getCourses();

            return  ResponseEntity.ok( new ApiResponse("Courses Fetched Successfully" , courses));

//            Map<String,List<Course>> res= new HashMap<>();
//            res.put( "data" , co );
//            return ResponseEntity.ok( res);
//            //return  res;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    @GetMapping("/getCoursesByPage")
    public ResponseEntity< ApiResponse> getCoursesByPage(@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "3") int pageCount ,@RequestParam(defaultValue = "title") String sortBy ,@RequestParam(defaultValue = "ASC") String sortOrder  ){

        try{
            List<Course> co=courseService.getCoursesByPages(pageNo,pageCount,sortBy,sortOrder);

            return  ResponseEntity.ok( new ApiResponse("Courses Fetched Successfully" , co));

//            Map<String,List<Course>> res= new HashMap<>();
//            res.put( "data" , co );
//            return ResponseEntity.ok( res);
//            //return  res;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @GetMapping("/search")
    public ResponseEntity< ApiResponse> searchCourses(@RequestParam(defaultValue = " ") String title ){

        try{
            List<Course> courses=courseService.searchCourses(title);

            return  ResponseEntity.ok( new ApiResponse("Courses Fetched Successfully" , courses));


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
