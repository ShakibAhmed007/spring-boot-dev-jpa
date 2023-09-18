package com.example.dev.springbootdev.jpqlexample.repository;

import com.example.dev.springbootdev.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("from Student")
    List<Student> findAllStudent();

}
