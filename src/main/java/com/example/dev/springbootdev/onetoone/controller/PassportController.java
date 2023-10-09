package com.example.dev.springbootdev.onetoone.controller;

import com.example.dev.springbootdev.customresponse.CustomResponse;
import com.example.dev.springbootdev.customresponse.CustomResponseUtil;
import com.example.dev.springbootdev.entities.Passport;
import com.example.dev.springbootdev.onetoone.dto.PassportDetailsDto;
import com.example.dev.springbootdev.onetoone.dto.PassportDto;
import com.example.dev.springbootdev.onetoone.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/passport")
public class PassportController {

    @Autowired
    private PassportService passportService;

    @GetMapping("/getAll")
    public ResponseEntity<CustomResponse<List<Passport>>> getAll(){
        List<Passport> passports = passportService.getAll();
        CustomResponse<List<Passport>> response = CustomResponseUtil.createResponse(200, passports, "Get /getall");
        response.setMessage("Successful");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity<CustomResponse<Passport>> save(@Valid @RequestBody PassportDto passportDto){
        Passport passport = passportService.save(passportDto);
        CustomResponse<Passport> response = CustomResponseUtil.createResponse(200, passport, "Post /save");
        response.setMessage("Successful");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<CustomResponse<Passport>> update(@Valid @RequestBody PassportDto passportDto){
        Passport passport = passportService.update(passportDto);
        CustomResponse<Passport> response = CustomResponseUtil.createResponse(200, passport, "Put /update");
        response.setMessage("Successful");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<CustomResponse<PassportDetailsDto>> getById(@PathVariable Long id){
        PassportDetailsDto passportDetailsDto = passportService.getById(id);
        CustomResponse<PassportDetailsDto> response = CustomResponseUtil.createResponse(200, passportDetailsDto, "Get /getById");
        response.setMessage("Successful");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getByUserId/{id}")
    public ResponseEntity<CustomResponse<PassportDetailsDto>> getByUserId(@PathVariable Long id){
        PassportDetailsDto passportDetailsDto = passportService.getByUserId(id);
        CustomResponse<PassportDetailsDto> response = CustomResponseUtil.createResponse(200, passportDetailsDto, "Get /getByUserId");
        response.setMessage("Successful");
        return ResponseEntity.ok(response);
    }
}
