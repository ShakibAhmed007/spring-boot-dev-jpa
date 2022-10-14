package com.example.dev.springbootdev.service;

import com.example.dev.springbootdev.entities.Accounts;
import com.example.dev.springbootdev.repository.QueryAnnotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryAnnotationService {

    @Autowired
    private QueryAnnotationRepository queryAnnotationRepository;

    public List<Accounts> getAllAccounts(){
        return queryAnnotationRepository.getAll();
    }

    public List<Accounts> getAllAccountsV2(){
        return queryAnnotationRepository.getAllV2();
    }

}
