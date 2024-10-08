package com.example.dev.springbootdev.basicjpaexample.service;


import com.example.dev.springbootdev.basicjpaexample.repository.AccountsRepository;
import com.example.dev.springbootdev.entities.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountsService {

    @Autowired
    private AccountsRepository accountsRepository;

    public void add(Accounts acc) throws Exception{
        accountsRepository.save(acc);
    }

    public void edit(Accounts acc) throws Exception{
        accountsRepository.save(acc);
    }

    public List<Accounts> getAll(){
        return (List<Accounts>) accountsRepository.findAll();
    }

    public List<Accounts> getAllByEmail(String email){
        return accountsRepository.findByUserEmail(email);
    }

    public List<Accounts> getAllByRole(String role){
        return accountsRepository.findByUserRole(role);
    }

    public Page<Accounts> getAllByPagination(Integer pageNumber, Integer pageSize, String sortBy, Boolean isAscending){
        Sort sort = Sort.unsorted();

        if (sortBy != null && !sortBy.trim().isEmpty()) {
            String[] sortFields = sortBy.split(",");
            for (String field : sortFields) {
                field = field.trim();
                if (isAscending != null && isAscending) {
                    sort = sort.and(Sort.by(Sort.Order.asc(field)));
                } else {
                    sort = sort.and(Sort.by(Sort.Order.desc(field)));
                }
            }
        }
        Pageable pageable = PageRequest.of(pageNumber,pageSize, sort);
        return accountsRepository.findAll(pageable);
    }

    public Optional<Accounts> getById(Long id){
        Optional<Accounts> optional = accountsRepository.findById(id);
        return optional.stream().findFirst();
    }

    public void deleteAll()throws Exception{
        accountsRepository.deleteAll();
    }

    public void deleteById(Long id)throws Exception{
        accountsRepository.deleteById(id);
    }
}
