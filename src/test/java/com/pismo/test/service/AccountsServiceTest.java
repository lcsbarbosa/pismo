package com.pismo.test.service;

import com.pismo.test.model.Accounts;
import com.pismo.test.repository.AccountsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class AccountsServiceTest {
    private final Accounts accountOne = new Accounts(1L, "312412455");
    private final Accounts accountTwo = new Accounts(2L, "677312454");

    @InjectMocks
    private AccountsService service;

    @Mock
    private AccountsRepository repository;

    @Test
    public void shouldFindAllAccounts(){
        given(repository.findAll()).willReturn(List.of(accountOne, accountTwo));
        List<Accounts> accountsList = service.getAccounts();

        assertThat(accountsList).isNotNull();
        assertThat(accountsList.size()).isEqualTo(2);
    }

    @Test
    public void shouldFindAccountById(){

        given(repository.findById(1L)).willReturn(Optional.of(accountOne));

        Accounts account = service.getAccountById(accountOne.getId());

        // then
        assertThat(account).isNotNull();
    }

    @Test
    public void shouldCreateAccount(){
        given(repository.save(accountOne)).willReturn(accountOne);

        Accounts accountsSave = service.create(accountOne);
        System.out.println(accountsSave);

        assertThat(accountsSave).isNotNull();
    }
}