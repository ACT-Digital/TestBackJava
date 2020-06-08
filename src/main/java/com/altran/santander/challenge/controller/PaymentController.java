package com.altran.santander.challenge.controller;

import com.altran.santander.challenge.model.Payment;
import com.altran.santander.challenge.model.dto.request.CardPaymentIntegrationRequestDTO;
import com.altran.santander.challenge.model.dto.request.EditCategoryRequestDTO;
import com.altran.santander.challenge.model.dto.request.PaymentRequestDTO;
import com.altran.santander.challenge.model.dto.response.IdResponseDTO;
import com.altran.santander.challenge.model.dto.response.PaymentResponseDTO;
import com.altran.santander.challenge.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Calendar;
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

    @PostMapping
    public ResponseEntity<IdResponseDTO> save(
            @RequestBody PaymentRequestDTO paymentRequestDTO,
            UriComponentsBuilder uriBuilder) {

        Payment payment = paymentService.saveRequest(paymentRequestDTO);
        URI uri = uriBuilder.build("api/payment");
        return ResponseEntity.created(uri).body(new IdResponseDTO(payment.getId()));

    }

    @PostMapping("/card-payment-integration")
    public ResponseEntity<IdResponseDTO> cardPaymentIntegration(
            @RequestBody CardPaymentIntegrationRequestDTO cardPaymentIntegrationRequestDTO,
            UriComponentsBuilder uriBuilder) {

        Payment payment = paymentService.saveIntegration(cardPaymentIntegrationRequestDTO);
        URI uri = uriBuilder.build("api/payment");
        return ResponseEntity.created(uri).body(new IdResponseDTO(payment.getId()));

    }

    @GetMapping("/list-by-recent")
    public ResponseEntity<List<PaymentResponseDTO>> findAllByRecent() {

        return ResponseEntity.ok(paymentService.findAllByRecent()
                .stream()
                .map(PaymentResponseDTO::new)
                .collect(Collectors.toList()));

    }

    @GetMapping("/search-by-date/{date}")
    public ResponseEntity<List<PaymentResponseDTO>> findAllByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Calendar date) {

        if (!paymentService.existsPaymentDate(date)) {

            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(paymentService.findAllByDate(date)
                .stream()
                .map(PaymentResponseDTO::new)
                .collect(Collectors.toList()));

    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentResponseDTO> editCategory(
            @RequestBody EditCategoryRequestDTO editCategoryRequestDTO,
            @PathVariable Integer id) {

        if (!paymentService.existsPaymentId(id)) {

            return ResponseEntity.notFound().build();

        }

        Payment payment = paymentService.editCategory(editCategoryRequestDTO, id);

        if(payment.getCategory() != editCategoryRequestDTO.getCategory()) {

            return ResponseEntity.badRequest().build();

        }

        return ResponseEntity.ok(new PaymentResponseDTO(payment));

    }

}
