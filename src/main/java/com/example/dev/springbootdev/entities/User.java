package com.example.dev.springbootdev.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "user", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "status")
    @NotNull
    private Integer status;

    @Column(name = "created_on")
    @NotNull
    private LocalDateTime createdOn;

    @Column(name = "updated_on")
    @NotNull
    private LocalDateTime updatedOn;

    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Passport passport;

    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Nid nid;

    @PrePersist
    protected void onCreate(){
        this.createdOn = LocalDateTime.now();
        this.updatedOn = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedOn = LocalDateTime.now();
    }
}
