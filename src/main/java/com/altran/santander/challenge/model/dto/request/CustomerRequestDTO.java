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

    @JsonProperty("email")
    private String email;

    @JsonProperty("codigoprocesso")
    private Integer processId;

}
