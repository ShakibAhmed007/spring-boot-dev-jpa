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
public class NidDetailsDto {

    private Long id;
    private String number;
    private String fatherName;
    private String motherName;
    private String address;
    private Integer status;
    private User user;
}
