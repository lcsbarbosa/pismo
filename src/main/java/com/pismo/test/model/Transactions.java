package com.pismo.test.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long accounts_id;
    private Long operationType_id;
    private Float amount;
    private Date eventDate;

    public Transactions(Transactions transactions){
        this.accounts_id = transactions.getAccounts_id();
        this.operationType_id = transactions.getOperationType_id();
        this.amount = transactions.getAmount();
        this.eventDate = new Date();
    }

    public Transactions(Long id, Long accounts_id, Long operationType_id, Float amount){
        this.id = id;
        this.accounts_id = accounts_id;
        this.operationType_id = operationType_id;
        this.amount = amount;
    }
}
