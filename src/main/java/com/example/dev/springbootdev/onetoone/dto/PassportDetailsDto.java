package com.example.dev.springbootdev.onetoone.dto;

import com.example.dev.springbootdev.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PassportDetailsDto {
    private Long id;
    private String number;
    private User user;
}
