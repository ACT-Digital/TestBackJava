package com.altran.santander.challenge.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDTO implements Serializable {

    private Integer id;
    private String nome;
    private String email;
    private Integer codigoProcesso;

}
