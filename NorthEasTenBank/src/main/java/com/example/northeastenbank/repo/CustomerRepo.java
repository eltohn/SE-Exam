package com.example.northeastenbank.repo;

import com.example.northeastenbank.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
