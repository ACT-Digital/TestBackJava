package com.altran.santander.challenge.model.dto.request;

import com.altran.santander.challenge.model.Process;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessRequestDTO implements Serializable {

    @JsonProperty("sistema")
    @NotNull(message = "Nome do Sistema é obrigatório")
    private String systemName;

    @NotNull(message = "Status é obrigatório")
    private Process.Status status;

}
