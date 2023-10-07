package com.kamar.ticketing_system_fin.banking.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {

    private int userId;
    private String accountType;
    private int balance;
}
