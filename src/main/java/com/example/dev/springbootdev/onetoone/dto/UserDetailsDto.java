package com.example.dev.springbootdev.onetoone.dto;

import com.example.dev.springbootdev.entities.Passport;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDto {

    private Long id;
    private String name;
    private Integer status;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private Passport passport;
}
