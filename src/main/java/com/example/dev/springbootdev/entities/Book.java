package com.example.dev.springbootdev.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name="book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="book_name")
    @NotNull
    private String bookName;

    @Column(name="author_name")
    @NotNull
    private String authorName;

    @Column(name="genre")
    @NotNull
    private String genre;

    @Column(name="price")
    @NotNull
    private Double price;

    @Column(name="page_count")
    @NotNull
    private Integer pageCount;

    @Column(name="description")
    @NotNull
    private String description;

    @Column(name = "status_id")
    @NotNull
    private Integer statusId;

    @Column(name="published_date")
    @NotNull
    private LocalDateTime publishedDate;

    @Column(name="created_on")
    @NotNull
    private LocalDateTime createdOn;

    @Column(name="updated_on")
    @NotNull
    private LocalDateTime updatedOn;

}
