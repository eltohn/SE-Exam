package com.example.northeastenbank.service;

import com.example.northeastenbank.model.Account;

import java.util.List;

public interface AccountService {
    Account addAccount(Account account);

    List<Account> getAllAccounts();

    List<Account> getAllPrimeAccs();

    List<Account> getDepositAccounts();
}
