package com.example.dev.springbootdev.onetoone.dto;

import com.example.dev.springbootdev.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PassportDetailsDto {
    private Long id;
    private String number;
    private User user;
}
