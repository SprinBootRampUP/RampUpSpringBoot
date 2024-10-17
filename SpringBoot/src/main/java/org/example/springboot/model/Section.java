package org.example.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
public class Section {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String orderNumber;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;


    @OneToMany(mappedBy = "section" )
    private List<Lecture> lectures;

    @Override
    public String toString() {
        return " ";

    }
}
