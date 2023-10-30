package com.example.dev.springbootdev.onetomany.repository;

import com.example.dev.springbootdev.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
