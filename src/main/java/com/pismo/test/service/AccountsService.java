package com.pismo.test.service;

import com.pismo.test.model.Accounts;
import com.pismo.test.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountsService {

    @Autowired
    private AccountsRepository repository;

    public Accounts create(Accounts accounts){
        return this.repository.save(accounts);
    }
}
