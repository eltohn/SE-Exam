package com.example.northeastenbank.service;

import com.example.northeastenbank.model.Customer;
import com.example.northeastenbank.repo.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepo customerRepo;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }
}
