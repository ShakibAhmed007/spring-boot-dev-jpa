package com.example.dev.springbootdev.onetoone.repository;

import com.example.dev.springbootdev.entities.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Long> {
}
