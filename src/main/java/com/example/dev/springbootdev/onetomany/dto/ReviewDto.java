package com.example.dev.springbootdev.onetomany.dto;

import com.example.dev.springbootdev.entities.Course;
import com.example.dev.springbootdev.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
    private Long id;
    private String comment;
    private Integer rating;
    private Long userId;
    private Long courseId;
    private Integer status;
}
