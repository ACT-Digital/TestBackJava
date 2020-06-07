package com.altran.santander.challenge.controller;

import com.altran.santander.challenge.model.Customer;
import com.altran.santander.challenge.model.dto.request.CustomerRequestDTO;
import com.altran.santander.challenge.model.dto.response.CustomerResponseDTO;
import com.altran.santander.challenge.model.dto.response.IdResponseDTO;
import com.altran.santander.challenge.repository.CustomerRepository;
import com.altran.santander.challenge.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Transactional
@RequestMapping("api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    private ResponseEntity<List<CustomerResponseDTO>> findAll() {

        return ResponseEntity.ok(customerService.findAll()
                .stream()
                .map(CustomerResponseDTO::new)
                .collect(Collectors.toList()));

    }

    @PostMapping
    private ResponseEntity<IdResponseDTO> save(@RequestBody CustomerRequestDTO customerRequestDTO, UriComponentsBuilder uriBuilder) {

        Customer customer = customerService.saveRequest(customerRequestDTO);
        URI uri = uriBuilder.build("api/customer");
        return ResponseEntity.created(uri).body(new IdResponseDTO(customer.getId()));

    }

}
