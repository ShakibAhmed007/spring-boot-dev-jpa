package com.example.dev.springbootdev.onetoone.repository;

import com.example.dev.springbootdev.entities.Nid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NidRepository extends JpaRepository<Nid, Long> {
}
