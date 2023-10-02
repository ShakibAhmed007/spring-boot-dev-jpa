package com.example.dev.springbootdev.onetoone.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PassportDto {

    private Long id;
    private String number;
    private Long userId;
    private Integer status;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

}
