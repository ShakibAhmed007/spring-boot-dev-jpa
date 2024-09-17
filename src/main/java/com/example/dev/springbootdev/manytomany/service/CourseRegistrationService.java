package com.example.dev.springbootdev.manytomany.service;

import com.example.dev.springbootdev.entities.Course;
import com.example.dev.springbootdev.entities.CourseRegistration;
import com.example.dev.springbootdev.entities.Student;
import com.example.dev.springbootdev.jpqlexample.repository.StudentRepository;
import com.example.dev.springbootdev.manytomany.dto.CourseRegistrationDTO;
import com.example.dev.springbootdev.manytomany.repository.CourseRegistrationRepository;
import com.example.dev.springbootdev.onetomany.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseRegistrationService {

    @Autowired
    private CourseRegistrationRepository courseRegistrationRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public CourseRegistration save(CourseRegistrationDTO courseRegistrationDTO){
        Optional<Student> studentOptional = Optional.of(
                studentRepository.findById(courseRegistrationDTO.getStudentId()).orElseThrow(() -> new IllegalArgumentException("Invalid Student id")));
        Optional<Course> courseOptional = Optional.of(
                courseRepository.findById(courseRegistrationDTO.getCourseId()).orElseThrow(() -> new IllegalArgumentException("Invalid Course id")));

        if(studentOptional.isPresent() && courseOptional.isPresent()){
            CourseRegistration registration = new CourseRegistration();
            registration.setStudent(studentOptional.get());
            registration.setCourse(courseOptional.get());
            return courseRegistrationRepository.save(registration);
        } else {
            return null;
        }
    }

    public List<CourseRegistration> getAllCourseRegistration(){
        return courseRegistrationRepository.findAll();
    }

    public List<CourseRegistration> getAllCourseRegistrationByStudentId(Long studentId){
        return courseRegistrationRepository.findByStudentId(studentId);
    }

    public List<CourseRegistration> getAllCourseRegistrationByCourseId(Long courseId){
        return courseRegistrationRepository.findByCourseId(courseId);
    }
}
