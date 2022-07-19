package com.pismo.test.service;

import com.pismo.test.model.Transactions;
import com.pismo.test.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionsService {

    @Autowired
    TransactionsRepository repository;

    public Transactions create(Transactions transactions){
        return repository.save(transactions);
    }
}
