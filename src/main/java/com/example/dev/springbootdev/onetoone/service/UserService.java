package com.example.dev.springbootdev.onetoone.service;

import com.example.dev.springbootdev.entities.User;
import com.example.dev.springbootdev.onetoone.dto.UserDetailsDto;
import com.example.dev.springbootdev.onetoone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public UserDetailsDto getById(Long id) {
        UserDetailsDto userDetailsDto = new UserDetailsDto();
        User user = userRepository.getById(id);
        userDetailsDto.setId(user.getId());
        userDetailsDto.setName(user.getName());
        userDetailsDto.setCreatedOn(user.getCreatedOn());
        userDetailsDto.setUpdatedOn(user.getUpdatedOn());
        userDetailsDto.setStatus(user.getStatus());
        userDetailsDto.setPassport(user.getPassport());
        return userDetailsDto;
    }
}
