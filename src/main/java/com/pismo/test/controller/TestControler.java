package com.pismo.test.controller;

import com.pismo.test.model.Accounts;
import com.pismo.test.model.Transactions;
import com.pismo.test.model.dto.TransactionsDTO;
import com.pismo.test.service.AccountsService;
import com.pismo.test.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;


@RestController
public class TestControler {

    @Autowired
    private TransactionsService transactionsService;

    @Autowired
    private AccountsService accountsService;

    @GetMapping("/health")
    public String health() {
        return "Up";
    }

    @GetMapping("/getAccounts")
    public ResponseEntity<List<Accounts>> getAccounts(){
        return ResponseEntity.ok(accountsService.getAccounts());
    }

    @GetMapping("/getTransactions")
    public ResponseEntity<List<Transactions>> getTransactions(){
        return ResponseEntity.ok(transactionsService.getTransactions());
    }

    @GetMapping("/accountsId/{id}")
    public ResponseEntity<Accounts> getAccountById(@PathVariable Long id){
        return ResponseEntity.ok(accountsService.getAccountById(id));
    }

    @GetMapping("/transactionsId/{id}")
    public ResponseEntity<Transactions> getTransactionsById(@PathVariable Long id){
        return ResponseEntity.ok(transactionsService.getTransactionById(id));
    }

    @PostMapping("/accounts")
    public ResponseEntity<Accounts> createAccounts(@Valid @RequestBody Accounts accounts){
        return ResponseEntity.status(HttpStatus.CREATED).body(accountsService.create(accounts));
    }

    @PostMapping("/transactions")
    public ResponseEntity<TransactionsDTO> createTransactions(@Valid @RequestBody Transactions transactions){
        return transactionsService.create(transactions);
    }


}