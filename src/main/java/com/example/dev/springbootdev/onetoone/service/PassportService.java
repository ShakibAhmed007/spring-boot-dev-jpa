package com.example.dev.springbootdev.onetoone.service;

import com.example.dev.springbootdev.entities.Passport;
import com.example.dev.springbootdev.entities.User;
import com.example.dev.springbootdev.exception.CustomException;
import com.example.dev.springbootdev.onetoone.dto.PassportDetailsDto;
import com.example.dev.springbootdev.onetoone.dto.PassportDto;
import com.example.dev.springbootdev.onetoone.repository.PassportRepository;
import com.example.dev.springbootdev.onetoone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PassportService {

    @Autowired
    private PassportRepository passportRepository;

    @Autowired
    private UserRepository userRepository;


    public List<Passport> getAll() {
        return passportRepository.findAll();
    }

    @Transactional
    public Passport save(PassportDto passportDto) {
        User user = userRepository.findById(passportDto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with "+ passportDto.getUserId()));
        Passport passport = new Passport();
        passport.setId(passportDto.getId());
        passport.setNumber(passportDto.getNumber());
        passport.setUser(user);
        passport.setStatus(passportDto.getStatus());
        return passportRepository.save(passport);
    }

    @Transactional
    public Passport update(PassportDto passportDto) {
        Optional<Passport> optionalPassport = passportRepository.findById(passportDto.getId());
        if (optionalPassport.isPresent()) {
            User user = userRepository.findById(passportDto.getUserId())
                    .orElseThrow(() -> new EntityNotFoundException("User not found with "+ passportDto.getUserId()));
            Passport passport = optionalPassport.get();
            passport.setNumber(passportDto.getNumber());
            passport.setUser(user);
            passport.setStatus(passportDto.getStatus());
            return passportRepository.save(passport);
        } else {
            throw new CustomException(404, "Passport not found with ID: " + passportDto.getId());
        }
    }

    public PassportDetailsDto getById(Long id) {
        Optional<Passport> passportOptional = passportRepository.findById(id);
        if(passportOptional.isPresent()){
            Passport passport = passportOptional.get();
            PassportDetailsDto passportDetailsDto = new PassportDetailsDto();
            passportDetailsDto.setId(passport.getId());
            passportDetailsDto.setNumber(passport.getNumber());
            passportDetailsDto.setUser(passport.getUser());
            return passportDetailsDto;
        } else {
            throw new CustomException(404, "Passport not found with ID: " + id);
        }
    }

    public PassportDetailsDto getByUserId(Long id) {
        Passport passport = passportRepository.findByUserId(id);
        if(passport != null){
            PassportDetailsDto passportDetailsDto = new PassportDetailsDto();
            passportDetailsDto.setId(passport.getId());
            passportDetailsDto.setNumber(passport.getNumber());
            passportDetailsDto.setUser(passport.getUser());
            return passportDetailsDto;
        } else {
            throw new CustomException(404, "Passport not found with UserID: " + id);
        }
    }
}
