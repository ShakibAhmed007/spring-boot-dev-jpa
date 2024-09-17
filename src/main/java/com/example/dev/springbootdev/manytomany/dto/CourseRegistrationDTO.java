package com.example.dev.springbootdev.manytomany.dto;

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
public class CourseRegistrationDTO {

    private Long studentId;
    private Long courseId;
}
