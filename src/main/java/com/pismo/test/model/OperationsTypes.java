package com.pismo.test.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class OperationsTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Description description;
}
