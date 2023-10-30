package com.example.dev.springbootdev.onetomany.service;

import com.example.dev.springbootdev.entities.Course;
import com.example.dev.springbootdev.exception.CustomException;
import com.example.dev.springbootdev.onetomany.dto.CourseDetailsDto;
import com.example.dev.springbootdev.onetomany.dto.CourseDto;
import com.example.dev.springbootdev.onetomany.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public CourseDetailsDto getById(Long id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if(courseOptional.isPresent()){
            Course course = courseOptional.get();
            CourseDetailsDto courseDetailsDto = new CourseDetailsDto();
            courseDetailsDto.setId(course.getId());
            courseDetailsDto.setTitle(course.getTitle());
            courseDetailsDto.setDescription(course.getDescription());
            courseDetailsDto.setAuthor(course.getAuthor());
            courseDetailsDto.setStatus(course.getStatus());
            courseDetailsDto.setReviewList(course.getReviewList());
            return courseDetailsDto;
        } else {
            throw new CustomException(404, "Course not found with Id: "+ id);
        }
    }

    public Course save(CourseDto courseDto) {
        Course course = new Course();
        course.setTitle(courseDto.getTitle());
        course.setDescription(courseDto.getDescription());
        course.setAuthor(courseDto.getAuthor());
        course.setStatus(courseDto.getStatus());
        return courseRepository.save(course);
    }

    public Course update(CourseDto courseDto) {
        Optional<Course> courseOptional = courseRepository.findById(courseDto.getId());
        if(courseOptional.isPresent()){
            Course course = courseOptional.get();
            course.setTitle(courseDto.getTitle());
            course.setDescription(courseDto.getDescription());
            course.setAuthor(courseDto.getAuthor());
            course.setStatus(courseDto.getStatus());
            return courseRepository.save(course);
        } else {
            throw new CustomException(404, "Course not found with Id: "+ courseDto.getId());
        }
    }

    public void delete(Long id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if(courseOptional.isPresent()){
            courseRepository.deleteById(id);
        } else {
            throw new CustomException(404, "Course not found with Id: "+ id);
        }
    }
}
