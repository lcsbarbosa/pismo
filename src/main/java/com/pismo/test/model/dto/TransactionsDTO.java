package com.pismo.test.model.dto;

import com.pismo.test.model.Accounts;
import com.pismo.test.model.OperationsTypes;
import com.pismo.test.model.Transactions;
import lombok.Getter;

@Getter
public class TransactionsDTO {

    private Long account;
    private Long operationType;
    private Float amount;

    public TransactionsDTO(Transactions transactions){
        this.account = transactions.getAccounts_id();
        this.operationType = transactions.getOperationType_id();
        this.amount = transactions.getAmount();
    }
}
