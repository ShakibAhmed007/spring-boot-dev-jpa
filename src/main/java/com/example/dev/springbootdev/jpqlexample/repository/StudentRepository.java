package com.example.dev.springbootdev.jpqlexample.repository;

import com.example.dev.springbootdev.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("from Student")
    List<Student> findAllStudent();

    @Query("SELECT std FROM Student std LEFT JOIN std.courseRegistrations cr WHERE cr.course IS NULL")
//    @Query("SELECT std FROM Student std WHERE NOT EXISTS (SELECT cr FROM CourseRegistration cr WHERE cr.student = std)")
//    @Query("SELECT std FROM Student std WHERE std.courseRegistrations IS EMPTY")
//    @Query("SELECT std FROM Student std WHERE std.id NOT IN (SELECT cr.student.id FROM CourseRegistration cr)")
    List<Student> findStudentsNotRegisteredInAnyCourse();

//    @Query()
//    List<Student> findCoursesWithAtLeastTwoStudents();



}
