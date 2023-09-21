package com.example.dev.springbootdev.onetoone.repository;

import com.example.dev.springbootdev.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
