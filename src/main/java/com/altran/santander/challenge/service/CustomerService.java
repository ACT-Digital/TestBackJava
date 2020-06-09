package com.altran.santander.challenge.service;

import com.altran.santander.challenge.model.Customer;
import com.altran.santander.challenge.model.Process;
import com.altran.santander.challenge.model.dto.request.CustomerRequestDTO;
import com.altran.santander.challenge.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProcessService processService;

    public List<Customer> findAll() {

        return customerRepository.findAll();

    }

    public Customer save(Customer customer) {

        return customerRepository.save(customer);

    }

    public Customer saveRequest(CustomerRequestDTO customerRequestDTO) {

        Customer customer = new Customer(customerRequestDTO);
        Process process = processService.findById(customerRequestDTO.getProcessId());
        customer.setProcess(process);

        return this.save(customer);

    }

    public Customer findById(Integer id) {

        return customerRepository.findById(id).orElse(null);

    }

}
