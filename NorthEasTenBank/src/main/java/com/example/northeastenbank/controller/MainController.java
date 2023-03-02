package com.example.northeastenbank.controller;


import com.example.northeastenbank.model.Account;
import com.example.northeastenbank.model.Customer;
import com.example.northeastenbank.service.AccountService;
import com.example.northeastenbank.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class MainController {

    private final CustomerService customerService;
    private final AccountService accountService;


    @GetMapping("/hello")
    private String hello(){
        return "hello";
    }
    @GetMapping("/allcustomers")
    private List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    @GetMapping("/allaccounts")
    private List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }
    @PostMapping ("/addaccount")
    private Account addCustomer(@Valid @RequestBody Account account){
        return accountService.addAccount(account);
    }


    ///111111
//    Checking
    //Saving
    //Loan
    @GetMapping("/depositaccounts")
    private List<Account> getDepositAccounts(){
        return accountService.getDepositAccounts();
    }


    //2222
    @GetMapping("/liquidity")
    private String getLiquidityPosition(){
        List<Account> accounts = accountService.getAllAccounts();
        Long deposit = 0L;
        Long loan = 0L;
        for(Account a: accounts){
            if(a.getAccountType().equals("Loan")){
               loan += a.getBalance();
            }else{
                deposit += a.getBalance();
            }
        }
        return "currentLiquidity:" +  (deposit - loan);
    }

    ////333333
    @GetMapping("/prime")
    private List<Account> getAllPrimeAccounts(){
        return accountService.getAllPrimeAccs();
    }

    //444444444
    @PostMapping ("/addcustomer")
    private Customer addCustomer(@Valid @RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

}
