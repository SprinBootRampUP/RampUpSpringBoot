package org.example.springboot.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data

public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn( name = "section_id")
    @JsonBackReference
    private Section section;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "resource_id" )
    @JsonManagedReference
    private Resource resource;

    @Override
    public String toString(){
        return " ";

    }

}
