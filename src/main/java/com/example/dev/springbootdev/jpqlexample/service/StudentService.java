package com.example.dev.springbootdev.jpqlexample.service;

import com.example.dev.springbootdev.entities.Student;
import com.example.dev.springbootdev.jpqlexample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public List<Student> getAll() {
        return studentRepository.findAll();
    }
}
