package org.example.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name ="section")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String orderNumber;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;


    @OneToMany(mappedBy = "section",cascade = CascadeType.ALL )
    private List<Lecture> lectures;

    @Override
    public String toString() {
        return " ";

    }
}
