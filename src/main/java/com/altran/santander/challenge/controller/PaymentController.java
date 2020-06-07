package com.altran.santander.challenge.controller;

import com.altran.santander.challenge.model.Payment;
import com.altran.santander.challenge.model.dto.request.PaymentRequestDTO;
import com.altran.santander.challenge.model.dto.response.IdResponseDTO;
import com.altran.santander.challenge.model.dto.response.PaymentResponseDTO;
import com.altran.santander.challenge.service.PaymentService;
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
@RequestMapping("api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<PaymentResponseDTO>> findAll() {

        return ResponseEntity.ok(paymentService.findAll()
                .stream()
                .map(PaymentResponseDTO::new)
                .collect(Collectors.toList()));

    }

    /** Funcionalidade: Integração de gastos por cartão */
    @PostMapping
    public ResponseEntity<IdResponseDTO> save(@RequestBody PaymentRequestDTO paymentRequestDTO, UriComponentsBuilder uriBuilder) {

        Payment payment = paymentService.saveRequest(paymentRequestDTO);
        URI uri = uriBuilder.build("api/payment");
        return ResponseEntity.created(uri).body(new IdResponseDTO(payment.getId()));

    }

    /** Funcionalidade: Filtro de gastos (Fazer pesquisa a partir do parâmetro data) */

    /** Funcionalidade: Listagem de gastos (Listar ordenando dados do mais recente para o mais antigo) */

    /** Funcionalidade: Categorização de gastos (Possibilidade de editar a descrição do pagamento somente quando não existir) */



}
