package com.altran.santander.challenge.model.dto.response;

import com.altran.santander.challenge.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDTO implements Serializable {

    private Integer id;
    private String nome;
    private String email;
    private String usuario;

    public CustomerResponseDTO(Customer customer) {

        this.id = customer.getId();
        this.nome = customer.getName();
        this.email = customer.getEmail();
        this.usuario = customer.getUsername();

    }

}
