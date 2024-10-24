package org.example.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.example.springboot.Enums.CourseLevel;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Date;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "Course")
@NamedQuery(
        name = "Course.findByTitle",
        query = "SELECT c FROM Course c WHERE c.title LIKE :title "
)
public class Course extends  BaseEntity {

    @Column(unique = true)
    @Basic(optional = false)
    private String title;

    @Column( columnDefinition = "VARCHAR(255) default 'Welcome to my course'")
    private String description;

    @Enumerated(EnumType.STRING)
    private CourseLevel courseLevel;

    private String price;

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

    @OneToMany(mappedBy = "course" ,cascade = CascadeType.ALL  )
    @JsonManagedReference
    @Fetch(FetchMode.JOIN)
    private List<Section> sections;

    @Override
    public String toString() {

        return "" ;
    }
}
