package com.pismo.test.controller;

import com.pismo.test.model.Accounts;
import com.pismo.test.model.Transactions;
import com.pismo.test.service.AccountsService;
import com.pismo.test.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/")
public class TestControler {

    @Autowired
    private TransactionsService transactionsService;

    @Autowired
    private AccountsService accountsService;

    @GetMapping("/health")
    public String health() {
        return "Up";
    }

    @PostMapping("/accounts")
    public ResponseEntity<Accounts> createAccounts(@Valid @RequestBody Accounts accounts){
        return ResponseEntity.status(HttpStatus.CREATED).body(accountsService.create(accounts));
    }

    @PostMapping("/transactions")
    public ResponseEntity<Transactions> createTransactions(@Valid @RequestBody Transactions transactions){
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionsService.create(transactions));
    }

}