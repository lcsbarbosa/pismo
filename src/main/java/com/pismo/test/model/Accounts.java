package com.pismo.test.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Accounts {

    @Id
    private Integer id;
    private Integer documentNumber;

}
