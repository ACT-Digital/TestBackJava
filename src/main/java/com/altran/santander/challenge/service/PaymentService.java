package com.altran.santander.challenge.service;

import com.altran.santander.challenge.model.Customer;
import com.altran.santander.challenge.model.Payment;
import com.altran.santander.challenge.model.dto.request.CardPaymentIntegrationRequestDTO;
import com.altran.santander.challenge.model.dto.request.EditCategoryRequestDTO;
import com.altran.santander.challenge.model.dto.request.PaymentRequestDTO;
import com.altran.santander.challenge.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
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

        setCategoryAutomatically(payment, customer);

        return this.save(payment);

    }

    public Payment saveIntegration(CardPaymentIntegrationRequestDTO cardPaymentIntegrationRequestDTO) {

        Payment payment = new Payment(cardPaymentIntegrationRequestDTO);
        Customer customer = customerService.findById(cardPaymentIntegrationRequestDTO.getCostumerId());
        payment.setCustomer(customer);

        setCategoryAutomatically(payment, customer); //se n der certo jogar na classe

        return this.save(payment);

    }

    /** Find all payments ordering by most recent date */
    public List<Payment> findAllByRecent() {

        return paymentRepository.findAllByOrderByDateDesc();

    }

    /** Find all payments based on the parameter date */
    public List<Payment> findAllByDate(Calendar date) {

        return paymentRepository.findAllByDate(date);

    }

    /** Method for user allow user to edit empty payment category */
    public Payment editCategory(EditCategoryRequestDTO editCategoryRequestDTO, Integer id) {

        Payment payment = paymentRepository.findById(id).get();

        if (payment.getCategory() != null) {

            return payment;

        }

        payment.setCategory(editCategoryRequestDTO.getCategory());

        return this.save(payment);

    }

    /** Method used to check if exist a payment with the parameter date */
    public boolean existsPaymentDate(Calendar date) {

        return paymentRepository.existsPaymentByDate(date);

    }

    /** Method used to check if exist a payment with the parameter id */
    public boolean existsPaymentId(Integer id) {

        return paymentRepository.existsPaymentById(id);

    }

    /** Set category based on consumer descriptions */
    public void setCategoryAutomatically(Payment payment, Customer customer) {

        if (payment.getDescription() != null) {

            String category = paymentRepository.categoryAutoSearch(payment.getDescription(), customer.getId());

            if (category != null && category != "null") {

                payment.setCategory(category);

            }

        }

    }

}

