package com.altran.santander.challenge.model.dto.response;

import com.altran.santander.challenge.model.Payment;
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
    private Double valor;
    private Integer codigoUsuario;
    private Date data;

    public PaymentResponseDTO(Payment payment) {

        this.id = payment.getId();
        this.valor = payment.getValue();
        this.codigoUsuario = payment.getCustomer().getId();
        this.data = payment.getDate();

    }

}
