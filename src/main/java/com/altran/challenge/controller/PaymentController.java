package com.altran.challenge.controller;

import com.altran.challenge.model.Payment;
import com.altran.challenge.repository.PaymentRepository;
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
@RequestMapping("api/payment")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Payment> findAll() {

        return paymentRepository.findAll();

    }

    /** Funcionalidade: Integração de gastos por cartão */
    @PostMapping
    public ResponseEntity<Payment> save(@RequestBody Payment payment, UriComponentsBuilder uriBuilder) {

        paymentRepository.save(payment);
        URI uri = uriBuilder.build("api/payment");
        return ResponseEntity.created(uri).body(payment);

    }

    /** Funcionalidade: Filtro de gastos (Fazer pesquisa a partir do parâmetro data) */

    /** Funcionalidade: Listagem de gastos (Listar ordenando dados do mais recente para o mais antigo) */

    /** Funcionalidade: Categorização de gastos (Possibilidade de editar a descrição do pagamento somente quando não existir) */



}
