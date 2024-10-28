package org.example.springboot;

import lombok.extern.slf4j.Slf4j;
import org.example.springboot.model.Author;
import org.example.springboot.service.AuthorService;
import org.example.springboot.service.CourseService;
import org.example.springboot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@Slf4j
@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.example.springboot.repository")
@EnableAspectJAutoProxy
public class Application implements CommandLineRunner {

//    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
//        System.out.println("Hello World!");
//    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        CourseService courseService = context.getBean(CourseService.class);

        AuthorService authorService = context.getBean(AuthorService.class);


        authorService.findAuthorsByCourseID(32L).forEach(
                author ->{
                    System.out.println( "Author: " + author.getFirstName() + " " + author.getLastName());
                }

        );
        log.info( "Author size"+ authorService.findAuthorsByCourseID(32L).size());

      //  List<Author> as=  authorService.findAuthorsByCourseID(2L);

      //  System.out.println(as);



//        authorService.findAuthorByName("Sharan").forEach(
//                author ->{
//                    System.out.println( "Author: " + author.getFirstName() + " " + author.getLastName());
//                }
//
//        );


        Long authorId = 2L;
        courseService.getCoursesByAuthor(authorId).forEach(course -> {
            System.out.println("Course Title: " + course.getTitle());
        });
//




    }


    @Autowired
    private TestService testService;

    @Override
    public void run(String... args) throws Exception {



       //testService.addCourseAndAuthors();
    }



}
