package com.example.northeastenbank.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;
    @NotNull(message = "Account number is required")
    private String accountNumber;
    @NotNull(message = "Account type is required")
    private String accountType;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOpened;
    @NotNull(message = "Balance type is required")
    private Long balance;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

//    @JsonBackReference
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "customer_id")
//    private Account account;
}