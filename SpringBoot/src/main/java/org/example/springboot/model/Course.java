package org.example.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springboot.Enums.CourseLevel;

import java.util.Date;
import java.util.List;


@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true)
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private CourseLevel courseLevel;
    private String price;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Course(){
        this.createdAt = new Date();
    }




    @ManyToMany
    @JoinTable(
            name = "author_courses" ,
            joinColumns ={
                    @JoinColumn(name = "course_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id")
            }
    )
    private List<Author> authors;

    @OneToMany(mappedBy = "course" ,cascade = CascadeType.ALL)
    private List<Section> sections;

    @Override
    public String toString() {

        return "Course" + title + " "+description + "sec size " + sections.size() ;
    }
}
