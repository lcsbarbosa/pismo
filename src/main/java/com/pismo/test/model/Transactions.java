package com.pismo.test.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Accounts account;

    @ManyToOne
    private OperationsTypes operationType;

    private Float amount;
    private LocalDateTime eventDate;

}
