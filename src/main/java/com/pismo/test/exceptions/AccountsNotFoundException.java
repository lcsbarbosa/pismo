package com.pismo.test.exceptions;

public class AccountsNotFoundException extends RuntimeException {

    public AccountsNotFoundException(Long id){
        super("Account: " + id + "not found");
    }

    public AccountsNotFoundException(){
        super("There is no data on Accounts database");
    }
}
