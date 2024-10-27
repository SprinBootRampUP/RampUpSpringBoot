package org.example.springboot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.example.springboot.Dtos.CourseDto;
import org.example.springboot.Dtos.LectureDto;
import org.example.springboot.Dtos.SectionDto;
import org.example.springboot.model.Course;
import org.example.springboot.model.Lecture;
import org.example.springboot.model.Resource;
import org.example.springboot.model.Section;
import org.example.springboot.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
public class CourseService {

//    @Autowired
//    private CourseRepository courseRepository;


    @javax.annotation.Resource(name="CourseRepository")
    private CourseRepository courseRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public List<Course> getCoursesByAuthor(Long authorId) {
        return courseRepository.findByAuthorsId(authorId);
    }

    @Transactional
    public void addCourseWithSections( CourseDto courseDto) {

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
        courseRepository.save(course);





      //  return
        //System.out.println("HIIIIIII"+course.toString());
      //  log.info( course.toString(),course.getSections().toString());
         //      Course c=  courseRepository.save(course);
       // System.out.printf("qqqqqqqqq!!!!!!!!!!!" +c);
    }

   // @Transactional
    public  List<CourseDto>  getCourses(){


        List<Course> courses = courseRepository.findAll();

        return courses.stream()
                .map(this::convertToCourseDTO)
                .collect(Collectors.toList());

      //  return courseRepository.findAll();
    }

    public  List<Course> getCoursesByPages(int pageNo, int pageCount ,String sortBy,String sortOrder){
        //Pageable pageable = PageRequest.of(pageNo,pageCount);
        Sort.Direction sortdirection= sortOrder.equalsIgnoreCase("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(pageNo,pageCount ,Sort.by(sortdirection,sortBy));
//It will return  object of pages - so use .get() , .tolist()
       return  courseRepository.findAll(pageable).get().toList();

       //return courseRepository.findAll();
    }


//    public  List<Course> searchCourses(String title){
//        return  courseRepository.findCourseByTitleContainingIgnoreCase(title);
//    }

    public  List<Course> searchCourses(String title){
        return  courseRepository.findCourseByTitleContainingIgnoreCase(title);
       // return  courseRepository.findByTitle("%" +title +"%");

    }
    private CourseDto convertToCourseDTO(Course course) {
        return objectMapper.convertValue(course, CourseDto.class);
    }
}
