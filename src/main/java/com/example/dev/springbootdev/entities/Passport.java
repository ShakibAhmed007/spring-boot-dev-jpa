package com.example.dev.springbootdev.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "passport")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    @NotNull
    private String number;

    @Column(name = "status")
    @NotNull
    private Integer status;

    @Column(name = "created_on")
    @NotNull
    private LocalDateTime createdOn;

    @Column(name = "updated_on")
    @NotNull
    private LocalDateTime updatedOn;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
