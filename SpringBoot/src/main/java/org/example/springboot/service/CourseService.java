package org.example.springboot.service;

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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

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

    @Transactional
    public  List<Course>  getCourses(){
              return courseRepository.findAll();
    }

}
