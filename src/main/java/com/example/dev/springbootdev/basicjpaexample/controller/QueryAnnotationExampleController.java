package com.example.dev.springbootdev.basicjpaexample.controller;



import com.example.dev.springbootdev.basicjpaexample.service.QueryAnnotationService;
import com.example.dev.springbootdev.entities.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/query-annotation")
public class QueryAnnotationExampleController {

    @Autowired
    private QueryAnnotationService queryAnnotationService;

    @GetMapping("/getAll")
    public List<Accounts> getAllAccounts(){
        return queryAnnotationService.getAllAccounts(); // query
    }

    @GetMapping("/getAllV2")
    public List<Accounts> getAllAccountsV2(){
        return queryAnnotationService.getAllAccountsV2(); // native query
    }

}
