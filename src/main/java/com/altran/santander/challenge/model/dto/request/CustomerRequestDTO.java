package com.altran.santander.challenge.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDTO implements Serializable {

    @JsonProperty("nome")
    @NotNull(message = "Nome é obrigatório")
    private String name;

    @NotNull(message = "E-mail é obrigatório")
    private String email;

    @JsonProperty("usuario")
    @NotNull(message = "Usuário é obrigatório")
    private String username;

    @JsonProperty("senha")
    @NotNull(message = "Senha é obrigatória")
    private String password;

    @JsonProperty("cartao")
    @NotNull(message = "Cartão é obrigatório")
    private Long card;

    @JsonProperty("codigosistema")
    @NotNull(message = "Código do Sistema é obrigatório")
    private Integer processId;

}
