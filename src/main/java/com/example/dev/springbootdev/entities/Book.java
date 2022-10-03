package com.example.dev.springbootdev.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="book_name")
    private String bookName;

    @Column(name="author_name")
    private String authorName;

    @Column(name="genre")
    private String genre;

    @Column(name="price")
    private Double price;

    @Column(name="page_count")
    private Integer pageCount;

    @Column(name="description")
    private String description;

    @Column(name="published_date")
    private LocalDateTime publishedDate;

    @Column(name="created_on")
    private LocalDateTime createdOn;

    @Column(name="updated_on")
    private LocalDateTime updatedOn;

}
