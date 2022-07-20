package com.pismo.test.service;

import com.pismo.test.exceptions.TransactionNotFoundException;
import com.pismo.test.model.Transactions;
import com.pismo.test.model.dto.TransactionsDTO;
import com.pismo.test.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class TransactionsService {

    @Autowired
    TransactionsRepository repository;

    public List<Transactions> getTransactions() {
        return repository.findAll();
    }

    public Transactions getTransactionById(Long id) {
        Transactions transactions = this.repository.findById(id)
                                    .orElseThrow(() -> new TransactionNotFoundException(id));
        return transactions;
    }

    public ResponseEntity<TransactionsDTO> create(Transactions transactions){
        Transactions transaction = new Transactions(transactions);
        repository.save(transaction);

        return ResponseEntity.status(HttpStatus.CREATED).body(new TransactionsDTO(transactions));
    }

}
