package com.example.dev.springbootdev.onetoone.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NidDto {

    private Long id;
    private String number;
    private String fatherName;
    private String motherName;
    private String address;
    private Integer status;
    private Long userId;
}
