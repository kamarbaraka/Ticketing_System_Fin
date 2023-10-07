package com.kamar.ticketing_system_fin.banking.entity;


import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    void transferLocally(Account source, Account destination, int amount);
}
