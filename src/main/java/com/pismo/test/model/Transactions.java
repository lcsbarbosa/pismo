package com.pismo.test.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Transactions {

    private Integer id;
    private Accounts account_Id;
    private OperationsTypes operationType_id;
    private Integer amount;
    private Date eventDat;

}
