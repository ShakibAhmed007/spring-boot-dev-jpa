package com.example.dev.springbootdev.onetoone.controller;

import com.example.dev.springbootdev.entities.User;
import com.example.dev.springbootdev.onetoone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public List<User> getAll(){
        return userService.getAllUser();
    }

    @PostMapping("/save")
    public User save(@Valid @RequestBody User user){
        return userService.save(user);
    }
}
