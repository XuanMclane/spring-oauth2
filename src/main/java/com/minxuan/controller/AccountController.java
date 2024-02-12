package com.minxuan.controller;

import com.minxuan.model.Accounts;
import com.minxuan.model.Customer;
import com.minxuan.repository.AccountsRepository;
import com.minxuan.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam String email) {
        List<Customer> customer = customerRepository.findByEmail(email);
        if (!customer.isEmpty()) {
            return accountsRepository.findByCustomerId(customer.get(0).getId());
        }
        return null;
    }

}
