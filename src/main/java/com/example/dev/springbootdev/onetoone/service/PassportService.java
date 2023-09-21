package com.example.dev.springbootdev.onetoone.service;

import com.example.dev.springbootdev.entities.Passport;
import com.example.dev.springbootdev.onetoone.repository.PassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassportService {

    @Autowired
    private PassportRepository passportRepository;


    public List<Passport> getAll() {
        return passportRepository.findAll();
    }

    public Passport save(Passport passport) {
        return passportRepository.save(passport);
    }
}
