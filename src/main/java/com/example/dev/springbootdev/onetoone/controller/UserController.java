package com.example.dev.springbootdev.onetoone.controller;

import com.example.dev.springbootdev.customresponse.CustomResponse;
import com.example.dev.springbootdev.customresponse.CustomResponseUtil;
import com.example.dev.springbootdev.entities.User;
import com.example.dev.springbootdev.onetoone.dto.UserDetailsDto;
import com.example.dev.springbootdev.onetoone.dto.UserDto;
import com.example.dev.springbootdev.onetoone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public ResponseEntity<CustomResponse<List<User>>> getAll(){
        List<User> users = userService.getAllUser();
        CustomResponse<List<User>> response = CustomResponseUtil.createResponse(200, users, "Get /getall");
        response.setMessage("Successful");
        return ResponseEntity.ok(response);
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<CustomResponse<UserDetailsDto>> getById(@PathVariable Long id){
        UserDetailsDto userDetailsDto = userService.getById(id);
        CustomResponse<UserDetailsDto> response = CustomResponseUtil.createResponse(200, userDetailsDto, "Get /getById");
        response.setMessage("Successful");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity<CustomResponse<User>> save(@Valid @RequestBody UserDto userDto){
        User savedUser = userService.save(userDto);
        CustomResponse<User> response = CustomResponseUtil.createResponse(200, savedUser, "Post /save");
        response.setMessage("Successful");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<CustomResponse<User>> update(@Valid @RequestBody UserDto userDto){
        User updatedUser = userService.update(userDto);
        CustomResponse<User> response = CustomResponseUtil.createResponse(200, updatedUser, "Put /update");
        return ResponseEntity.ok(response);
    }
}
