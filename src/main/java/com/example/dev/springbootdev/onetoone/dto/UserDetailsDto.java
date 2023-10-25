package com.example.dev.springbootdev.onetoone.dto;

import com.example.dev.springbootdev.entities.Nid;
import com.example.dev.springbootdev.entities.Passport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    private Nid nid;
}
