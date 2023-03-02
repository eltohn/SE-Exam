package com.example.northeastenbank.service;

import com.example.northeastenbank.model.Account;
import com.example.northeastenbank.repo.AccountRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepo accountRepo;
    @Override
    public Account addAccount(Account account) {
        return accountRepo.save(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }

    @Override
    public List<Account> getAllPrimeAccs() {
        return accountRepo.findAllAccountsBalGreaterThan();
    }

    @Override
    public List<Account> getDepositAccounts() {
        return accountRepo.findDepositAccounts();
    }
}
