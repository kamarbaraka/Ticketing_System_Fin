package com.kamar.ticketing_system_fin.banking.entity;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    private AccountService accountService;

    @BeforeEach
    void setup(){

        this.accountService = new AccountServiceImpl();
    }

    @Test
    void transferLocallyTest(){

        /*given*/
        User makena = new User(1, "makena");
        Account current = new Account(1, "current", 1500);
        Account savings = new Account(1, "savings", 2500);

        /*when*/
        accountService.transferLocally(current, savings, 700);

        /*then*/
        BDDAssertions.then(current.getBalance()).isEqualTo(800);
        BDDAssertions.then(savings.getBalance()).isEqualTo(3200);
    }

}