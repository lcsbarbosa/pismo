package com.pismo.test.service;

import com.pismo.test.exceptions.AccountsNotFoundException;
import com.pismo.test.model.Accounts;
import com.pismo.test.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountsService {

    @Autowired
    private AccountsRepository repository;

    public Accounts create(Accounts accounts){
        return this.repository.save(accounts);
    }

    public List<Accounts> getAccounts() {
        return repository.findAll();
    }

    public Accounts getAccountById(Long id) {
        Accounts account = this.repository.findById(id)
                            .orElseThrow(() -> new AccountsNotFoundException(id));
        return account;
    }


}
