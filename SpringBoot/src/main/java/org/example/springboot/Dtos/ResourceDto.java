package org.example.springboot.Dtos;

import lombok.Data;

@Data
public class ResourceDto {
    private Integer id;
    private String name;
    private int size;
    private String url;
    private LectureDto lecture;
}
