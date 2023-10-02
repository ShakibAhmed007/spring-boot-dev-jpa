package com.example.dev.springbootdev.onetoone.controller;

import com.example.dev.springbootdev.entities.Passport;
import com.example.dev.springbootdev.onetoone.dto.PassportDetailsDto;
import com.example.dev.springbootdev.onetoone.dto.PassportDto;
import com.example.dev.springbootdev.onetoone.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    public Passport save(@Valid @RequestBody PassportDto passportDto){
        return passportService.save(passportDto);
    }
    @PutMapping("/update")
    public Passport update(@Valid @RequestBody PassportDto passportDto){
        return passportService.update(passportDto);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<PassportDetailsDto> getById(@PathVariable Long id){
        PassportDetailsDto passportDetailsDto = passportService.getById(id);
        return ResponseEntity.ok(passportDetailsDto);
    }

    @GetMapping("/getByUserId/{id}")
    public ResponseEntity<PassportDetailsDto> getByUserId(@PathVariable Long id){
        PassportDetailsDto passportDetailsDto = passportService.getByUserId(id);
        return ResponseEntity.ok(passportDetailsDto);
    }
}
