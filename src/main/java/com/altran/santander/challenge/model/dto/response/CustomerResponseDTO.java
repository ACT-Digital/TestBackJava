package com.altran.santander.challenge.model.dto.response;

import com.altran.santander.challenge.model.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDTO implements Serializable {

    private Integer id;

    @JsonProperty("nome")
    private String name;

    private String email;

    @JsonProperty("usuario")
    private String username;

    public CustomerResponseDTO(Customer customer) {

        this.id = customer.getId();
        this.name = customer.getName();
        this.email = customer.getEmail();
        this.username = customer.getUsername();

    }

}
