package com.example.dev.springbootdev.jpqlexample.repository;

import com.example.dev.springbootdev.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
