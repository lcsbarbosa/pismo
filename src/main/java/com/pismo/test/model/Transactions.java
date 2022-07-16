package com.pismo.test.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transactions {

    @Id
    private Integer id;

    @ManyToOne
    private Accounts account_Id;

    @ManyToOne
    private OperationsTypes operationType_id;

    private Integer amount;
    private Date eventDat;

}
