package com.example.northeastenbank.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;
    @NotNull(message = "Name is required")
    private String firstName;
    @NotNull(message = "Lastname is required")
    private String lastName;


    @JsonManagedReference
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Account> accounts = new ArrayList<>();

//    @JsonManagedReference
//    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
//    private List<Customer> customer = new ArrayList<>();
}
