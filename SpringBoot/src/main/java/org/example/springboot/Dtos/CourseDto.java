package org.example.springboot.Dtos;

import lombok.Data;

import java.util.List;

@Data
public class CourseDto {

    private Long id;
    private String title;
    private String description;
    private List<AuthorDto> authors;
    private List<SectionDto> sections;


}
