package com.example.dev.springbootdev.onetomany.controller;

import com.example.dev.springbootdev.customresponse.CustomResponse;
import com.example.dev.springbootdev.customresponse.CustomResponseUtil;
import com.example.dev.springbootdev.entities.Review;
import com.example.dev.springbootdev.onetomany.dto.ReviewDto;
import com.example.dev.springbootdev.onetomany.service.Reviewservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private Reviewservice reviewservice;

    @GetMapping("/getAll")
    public ResponseEntity<CustomResponse<List<Review>>> getAll(){
        List<Review> reviewList = reviewservice.getAll();
        CustomResponse<List<Review>> response = CustomResponseUtil.createResponse(200, reviewList, "/GetAll");
        response.setMessage("Successful");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity<CustomResponse<Review>> save(@Valid @RequestBody ReviewDto reviewDto){
        Review reviewList = reviewservice.save(reviewDto);
        CustomResponse<Review> response = CustomResponseUtil.createResponse(200, reviewList, "/GetAll");
        response.setMessage("Successful");
        return ResponseEntity.ok(response);
    }
}
