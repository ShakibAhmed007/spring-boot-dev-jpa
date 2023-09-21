package com.example.dev.springbootdev.onetoone.controller;

import com.example.dev.springbootdev.entities.Passport;
import com.example.dev.springbootdev.onetoone.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/passport")
public class PassportController {

    @Autowired
    private PassportService passportService;

    @GetMapping("/getAll")
    public List<Passport> getAll(){
        return passportService.getAll();
    }

    @PostMapping("/save")
    public Passport save(@Valid @RequestBody Passport passport){
        return passportService.save(passport);
    }
}
