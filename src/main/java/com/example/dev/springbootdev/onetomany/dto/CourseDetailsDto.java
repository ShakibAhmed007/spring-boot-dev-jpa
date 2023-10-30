package com.example.dev.springbootdev.onetomany.dto;

import com.example.dev.springbootdev.entities.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDetailsDto {
    private Long id;
    private String title;
    private String description;
    private String author;
    private Integer status;
    private List<Review> reviewList;
}
