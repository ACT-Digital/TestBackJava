package com.altran.challenge.controller;

import com.altran.challenge.model.Customer;
import com.altran.challenge.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@Transactional
@RequestMapping("api/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    private List<Customer> findAll() {

        return customerRepository.findAll();

    }

    @PostMapping
    private ResponseEntity<Customer> save(@RequestBody Customer customer, UriComponentsBuilder uriBuilder) {

        customerRepository.save(customer);
        URI uri = uriBuilder.build("api/customer");
        return ResponseEntity.created(uri).body(customer);

    }

}
