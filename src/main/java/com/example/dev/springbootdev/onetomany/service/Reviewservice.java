package com.example.dev.springbootdev.onetomany.service;

import com.example.dev.springbootdev.entities.Course;
import com.example.dev.springbootdev.entities.Review;
import com.example.dev.springbootdev.entities.User;
import com.example.dev.springbootdev.exception.CustomException;
import com.example.dev.springbootdev.onetomany.dto.ReviewDto;
import com.example.dev.springbootdev.onetomany.repository.CourseRepository;
import com.example.dev.springbootdev.onetomany.repository.ReviewRepository;
import com.example.dev.springbootdev.onetoone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class Reviewservice {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;


    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    public Review save(ReviewDto reviewDto) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findById(reviewDto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with Id:" + reviewDto.getUserId())));
        Optional<Course> courseOptional = Optional.ofNullable(courseRepository.findById(reviewDto.getCourseId())
                .orElseThrow(() -> new EntityNotFoundException("Course not found with Id:" + reviewDto.getCourseId())));
        if(userOptional.isPresent() && courseOptional.isPresent()){
            Review review = new Review();
            review.setComment(reviewDto.getComment());
            review.setRating(reviewDto.getRating());
            review.setUser(userOptional.get());
            review.setCourse(courseOptional.get());
            review.setStatus(reviewDto.getStatus());
            return reviewRepository.save(review);
        } else {
            throw new CustomException(404, "User/Course not found !!!");
        }
    }
}
