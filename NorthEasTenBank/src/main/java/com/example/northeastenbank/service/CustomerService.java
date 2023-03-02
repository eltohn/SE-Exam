package com.example.northeastenbank.service;

import com.example.northeastenbank.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer customer);

    List<Customer> getAllCustomers();
}
