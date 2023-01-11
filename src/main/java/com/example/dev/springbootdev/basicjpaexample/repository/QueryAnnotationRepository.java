package com.example.dev.springbootdev.basicjpaexample.controller.repository;

import com.example.dev.springbootdev.basicjpaexample.controller.entities.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface QueryAnnotationRepository extends JpaRepository<Accounts, Long> {

    @Query("Select u from Accounts u")
    public List<Accounts> getAll();

    // native query
    @Query(value = "Select * from accounts", nativeQuery = true)
    public List<Accounts> getAllV2();

}
