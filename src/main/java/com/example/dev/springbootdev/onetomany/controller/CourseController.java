package com.example.dev.springbootdev.onetomany.controller;

import com.example.dev.springbootdev.customresponse.CustomResponse;
import com.example.dev.springbootdev.customresponse.CustomResponseUtil;
import com.example.dev.springbootdev.entities.Course;
import com.example.dev.springbootdev.onetomany.dto.CourseDetailsDto;
import com.example.dev.springbootdev.onetomany.dto.CourseDto;
import com.example.dev.springbootdev.onetomany.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/getAll")
    public ResponseEntity<CustomResponse<List<Course>>> getAllCourses(){
        List<Course> courses = courseService.getAll();
        CustomResponse<List<Course>> response = CustomResponseUtil.createResponse(200, courses, "/GetAll");
        response.setMessage("Successful");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<CustomResponse<CourseDetailsDto>> getById(@PathVariable("id") Long id){
        CourseDetailsDto course = courseService.getById(id);
        CustomResponse<CourseDetailsDto> response = CustomResponseUtil.createResponse(200, course, "/GetAll");
        response.setMessage("Successful");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity<CustomResponse<Course>> save(@Valid  @RequestBody CourseDto courseDto){
        Course course = courseService.save(courseDto);
        CustomResponse<Course> response = CustomResponseUtil.createResponse(200, course, "/Save");
        response.setMessage("Successfull");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<CustomResponse<Course>> update(@Valid @RequestBody CourseDto courseDto){
        Course course = courseService.update(courseDto);
        CustomResponse<Course> response = CustomResponseUtil.createResponse(200, course, "/Save");
        response.setMessage("Successfull");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CustomResponse<Course>> delete(@PathParam("id") Long id){
        courseService.delete(id);
        CustomResponse<Course> response = CustomResponseUtil.createResponse(200, null, "/Save");
        response.setMessage("Successfull");
        return ResponseEntity.ok(response);
    }
}
