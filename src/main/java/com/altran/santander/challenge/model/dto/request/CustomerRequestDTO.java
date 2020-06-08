package com.altran.santander.challenge.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDTO implements Serializable {

    @JsonProperty("nome")
    private String name;

    private String email;

    @JsonProperty("usuario")
    private String username;

    @JsonProperty("senha")
    private String password;

    @JsonProperty("cartao")
    private Long card;

    @JsonProperty("codigosistema")
    private Integer processId;

}
