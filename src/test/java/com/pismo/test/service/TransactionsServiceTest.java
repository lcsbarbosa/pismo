package com.pismo.test.service;

import com.pismo.test.model.Transactions;
import com.pismo.test.model.dto.TransactionsDTO;
import com.pismo.test.repository.TransactionsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
class TransactionsServiceTest {
    private final Transactions transactionOne = new Transactions(1L,1L,1L, (float) 99.99);
    private final Transactions transactionTwo = new Transactions(2L,2L,2L, (float) 109.50);


    @InjectMocks
    private TransactionsService service;

    @Mock
    private TransactionsRepository repository;

    private Transactions transactions;

    @BeforeEach
    public void setup() {
        transactions = Transactions.builder()
                .id(anyLong())
                .accounts_id(1L)
                .operationType_id(2L)
                .amount((float) 222.32)
                .eventDate(new Date())
                .build();
    }

    @Test
    public void shouldFindAllAccounts(){

        given(repository.findAll()).willReturn(List.of(transactionOne, transactionTwo));
        List<Transactions> transactionsList = service.getTransactions();

        assertThat(transactionsList).isNotNull();
        assertThat(transactionsList.size()).isEqualTo(2);
    }

    @Test
    public void shouldFindAccountById(){

        given(repository.findById(1L)).willReturn(Optional.of(transactionOne));
        Transactions transaction = service.getTransactionById(transactionOne.getId());

        assertThat(transaction).isNotNull();
    }

//    @Test
//    public void shouldCreateAccount(){
//        given(repository.save(transactions)).willReturn(transactions);
//
//        var transactionSave = service.create(transactions);
//        System.out.println(transactionSave);
//
//        assertThat(transactionSave).isNotNull();
//    }


}