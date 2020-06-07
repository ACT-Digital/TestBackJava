package com.altran.santander.challenge.service;

import com.altran.santander.challenge.model.Customer;
import com.altran.santander.challenge.model.Payment;
import com.altran.santander.challenge.model.dto.request.PaymentRequestDTO;
import com.altran.santander.challenge.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CustomerService customerService;

    public List<Payment> findAll() {

        return paymentRepository.findAll();

    }

    public Payment save(Payment payment) {

        return paymentRepository.save(payment);

    }

    public Payment saveRequest(PaymentRequestDTO paymentRequestDTO) {

        Payment payment = new Payment(paymentRequestDTO);
        Customer customer = customerService.findById(paymentRequestDTO.getCostumerId());
        payment.setCustomer(customer);

        return this.save(payment);

    }

}

