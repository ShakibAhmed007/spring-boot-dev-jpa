package com.example.dev.springbootdev.basicjpaexample.controller;

import com.example.dev.springbootdev.basicjpaexample.controller.entities.Accounts;
import com.example.dev.springbootdev.basicjpaexample.controller.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.*;

@RestController
@RequestMapping("/accounts")
public class AccountsController {

    @Autowired
    private AccountsService accountsService;

    @GetMapping("/getAll")
    public List<Accounts> getAll() {
        return accountsService.getAll();
    }

    @GetMapping("/getAllByPagination")
    public ResponseEntity<Object> getAll(@RequestParam(defaultValue = "0") Integer pageNumber, @RequestParam(defaultValue = "15") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy, @RequestParam(defaultValue = "false") Boolean isAscending) {
        Page<Accounts> page = accountsService.getAllByPagination(pageNumber, pageSize, sortBy, isAscending);
        List<Accounts> accounts = page.getContent();
        Map<String, Object> response = new HashMap<>();
        response.put("accounts", accounts);
        response.put("currentPage", page.getNumber());
        response.put("totalItems", page.getTotalElements());
        response.put("totalPages", page.getTotalPages());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getAllByEmail")
    public List<Accounts> getAllByEmail(@RequestParam String email) {
        return accountsService.getAllByEmail(email);
    }

    @GetMapping("/getAllByRole")
    public List<Accounts> getAllByRole(@RequestParam String role) {
        return accountsService.getAllByRole(role);
    }

    @GetMapping("/getById/{id}")
    public Optional<Accounts> getById(@PathVariable Long id) {
        return accountsService.getById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> add(@Valid @RequestBody Accounts accounts) throws Exception {
        accountsService.add(accounts);

        // add location in response header
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand("100").toUri(); // todo 100 should be from db
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/edit")
    public ResponseEntity<Object> edit(@Valid @RequestBody Accounts accounts) throws Exception {
        accountsService.edit(accounts);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Object> deleteAll() throws Exception {
        accountsService.deleteAll();
        return ResponseEntity.ok("Deleted Successfully");
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) throws Exception {
        accountsService.deleteById(id);
        return ResponseEntity.ok("Deleted By Id Successfully");
    }
}
