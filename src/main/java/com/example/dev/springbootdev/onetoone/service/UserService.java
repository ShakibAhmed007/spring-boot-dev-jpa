package com.example.dev.springbootdev.onetoone.service;

import com.example.dev.springbootdev.entities.User;
import com.example.dev.springbootdev.exception.CustomException;
import com.example.dev.springbootdev.onetoone.dto.UserDetailsDto;
import com.example.dev.springbootdev.onetoone.dto.UserDto;
import com.example.dev.springbootdev.onetoone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    public List<User> getAllUser() {
////        return userRepository.findAllByOrderByUpdatedOnDesc();
//        return userRepository.findAll();
//    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }


    public User save(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setStatus(userDto.getStatus());
        return userRepository.save(user);
    }

    public User update(UserDto userDto){
        Optional<User> userOptional = userRepository.findById(userDto.getId());
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setName(userDto.getName());
            user.setStatus(userDto.getStatus());
            return userRepository.save(user);
        } else {
            throw new CustomException(404, "User not found with ID: "+ userDto.getId());
        }
    }

    public UserDetailsDto getById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            UserDetailsDto userDetailsDto = new UserDetailsDto();
            userDetailsDto.setId(user.getId());
            userDetailsDto.setName(user.getName());
            userDetailsDto.setCreatedOn(user.getCreatedOn());
            userDetailsDto.setUpdatedOn(user.getUpdatedOn());
            userDetailsDto.setStatus(user.getStatus());
            userDetailsDto.setPassport(user.getPassport());
            userDetailsDto.setNid(user.getNid());
            return userDetailsDto;
        } else {
            throw new CustomException(404, "User not found with ID: "+ id);
        }
    }
}
