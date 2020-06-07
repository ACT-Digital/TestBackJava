package com.altran.santander.challenge.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestDTO implements Serializable {

    private String descricao;
    private Double valor;
    private Integer codigoUsuario;
    private Date data;

}
