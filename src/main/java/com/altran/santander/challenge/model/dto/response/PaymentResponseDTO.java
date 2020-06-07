package com.altran.santander.challenge.model.dto.response;

import com.altran.santander.challenge.model.Payment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponseDTO implements Serializable {

    private Integer id;

    @JsonProperty("valor")
    private Double value;

    @JsonProperty("codigousuario")
    private Integer customerId;

    @JsonProperty("data")
    private Date date;

    public PaymentResponseDTO(Payment payment) {

        this.id = payment.getId();
        this.value = payment.getValue();
        this.customerId = payment.getCustomer().getId();
        this.date = payment.getDate();

    }

}
