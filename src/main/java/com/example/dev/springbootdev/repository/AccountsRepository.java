package com.example.dev.springbootdev.repository;

import com.example.dev.springbootdev.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {
    List<Accounts> findByUserEmail(String email); // derived method
    List<Accounts> findByUserRole(String email); // derived method
}
