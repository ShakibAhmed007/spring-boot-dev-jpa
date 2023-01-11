package com.example.dev.springbootdev.basicjpaexample.controller.repository;

import com.example.dev.springbootdev.basicjpaexample.controller.entities.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {
    List<Accounts> findByUserEmail(String email); // derived method
    List<Accounts> findByUserRole(String email); // derived method
}
