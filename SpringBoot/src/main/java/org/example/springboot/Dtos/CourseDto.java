package org.example.springboot.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.example.springboot.Enums.CourseLevel;

import java.util.List;

@Data
public class CourseDto {

   // private Long id;
    private String title;
    private String description;
    @JsonIgnore
    private CourseLevel courseLevel;
    private List<AuthorDto> authors;
    private List<SectionDto> sections;


}
