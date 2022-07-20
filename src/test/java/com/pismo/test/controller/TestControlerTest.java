package com.pismo.test.controller;

import com.pismo.test.model.Accounts;
import com.pismo.test.model.Transactions;
import com.pismo.test.repository.AccountsRepository;
import com.pismo.test.repository.TransactionsRepository;
import com.pismo.test.service.AccountsService;
import com.pismo.test.service.TransactionsService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(TestControler.class)
class TestControlerTest {
    private final Accounts accountOne = new Accounts(1L, "312412455");
    private final Accounts accountTwo = new Accounts(2L, "677312454");
    private final Accounts accountThree = new Accounts(3L, "546757445");
    private final Transactions transactionOne = new Transactions(1L,1L,1L, (float) 99.99);

    private Long id;
    private Long accounts_id;
    private Long operationType_id;
    private Float amount;
    private Date eventDate;

    @MockBean
    private AccountsService accountsService;

    @MockBean
    private TransactionsService transactionsService;

    @MockBean
    private AccountsRepository accountsRepository;

    @MockBean
    private TransactionsRepository transactionsRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnSuccess_When_GetAllAccounts() throws Exception {
        List<Accounts> accounts = Arrays.asList(accountOne, accountTwo);

        Mockito.when(accountsService.getAccounts()).thenReturn(accounts);

        this.mockMvc.perform(get("/getAccounts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))
                .andExpect(jsonPath("$[0].documentNumber", Matchers.is("312412455")))
                .andExpect(jsonPath("$[1].documentNumber", Matchers.is("677312454")))
                .andReturn();
    }

    @Test
    public void shouldReturnSuccess_When_GetAccountById() throws Exception {
        Mockito.when(accountsService.getAccountById(3L)).thenReturn(accountThree);

        this.mockMvc.perform(get("/accountsId/{id}", 3L))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":3,\"documentNumber\":\"546757445\"}"))
                .andReturn();
    }

    @Test
    public void shouldReturnSuccess_When_GetTransactionsById() throws Exception {
        Mockito.when(transactionsService.getTransactionById(1l)).thenReturn(transactionOne);

        this.mockMvc.perform(get("/transactionsId/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"accounts_id\":1,\"operationType_id\":1,\"amount\":99.99,\"eventDate\":null}"))
                .andReturn();
    }

    @Test
    public void shouldReturnSuccess_When_CreateAccount() throws Exception {

        this.mockMvc.perform(post("/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"documentNumber\": \"12345678\"\n" +
                        "}"))
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    public void shouldReturnSuccess_When_CreateTransactions() throws Exception {

        this.mockMvc.perform(post("/transactions")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"accounts_id\": 4,\n" +
                        "  \"operationType_id\": 2,\n" +
                        "  \"amount\": \"899.99\"\n" +
                        "}"))
                .andExpect(status().isOk())
                .andReturn();
    }
}