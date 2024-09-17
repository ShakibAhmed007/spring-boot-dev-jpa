package com.example.dev.springbootdev.manytomany.controller;


import com.example.dev.springbootdev.entities.CourseRegistration;
import com.example.dev.springbootdev.manytomany.dto.CourseRegistrationDTO;
import com.example.dev.springbootdev.manytomany.service.CourseRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/course-Registration")
public class CourseRegistrationController {

    @Autowired
    private CourseRegistrationService courseRegistrationService;

    @PostMapping("/register")
    public ResponseEntity<CourseRegistration> registerStudentToCourse(@Valid @RequestBody CourseRegistrationDTO courseRegistrationDTO) {
        CourseRegistration registration = courseRegistrationService.save(courseRegistrationDTO);
        return ResponseEntity.ok(registration);
    }

    @GetMapping
    public List<CourseRegistration> getAllRegistrations() {
        return courseRegistrationService.getAllCourseRegistration();
    }

    @GetMapping("/student/{studentId}")
    public List<CourseRegistration> getRegistrationsByStudentId(@PathVariable Long studentId) {
        return courseRegistrationService.getAllCourseRegistrationByStudentId(studentId);
    }

    @GetMapping("/course/{courseId}")
    public List<CourseRegistration> getRegistrationsByCourseId(@PathVariable Long courseId) {
        return courseRegistrationService.getAllCourseRegistrationByCourseId(courseId);
    }
}
