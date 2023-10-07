package com.kamar.ticketing_system_fin.banking.entity;

public class AccountServiceImpl implements AccountService{
    @Override
    public void transferLocally(Account source, Account destination, int amount) {

        /*deduct the amount from the source*/
        source.setBalance(source.getBalance() - amount);
        /*credit the amount to the destination*/
        destination.setBalance(destination.getBalance() + amount);

    }
}
