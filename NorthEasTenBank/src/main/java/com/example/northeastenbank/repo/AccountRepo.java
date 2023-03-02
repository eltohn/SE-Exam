package com.example.northeastenbank.repo;

import com.example.northeastenbank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepo extends JpaRepository<Account,Long> {

    @Query("select a from Account a where a.balance > 100000")
    List<Account> findAllAccountsBalGreaterThan();

//    @Query("select t from Account t where t.accountType=d")
    @Query("SELECT a FROM Account a WHERE a.accountType IN ('Checking', 'Saving')")
    List<Account> findDepositAccounts();
}



//@Entity
//public class Account {
//    @Id
//    private Long id;
//
//    private String accountNumber;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "customer_id")
//    private Customer customer;
//
//    // other fields and methods
//}

//
//@Entity
//public class Customer {
//    @Id
//    private Long id;
//
//    private String firstName;
//
//    private String lastName;
//
//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    private List<Account> accounts = new ArrayList<>();
//
//    // other fields and methods
//}
