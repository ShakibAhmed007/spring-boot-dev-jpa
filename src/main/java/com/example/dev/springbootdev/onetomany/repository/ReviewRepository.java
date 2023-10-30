package com.example.dev.springbootdev.onetomany.repository;

import com.example.dev.springbootdev.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
