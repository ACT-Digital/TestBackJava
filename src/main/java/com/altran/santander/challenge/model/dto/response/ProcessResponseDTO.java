package com.altran.santander.challenge.model.dto.response;

import com.altran.santander.challenge.model.Process;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessResponseDTO implements Serializable {

    private Integer id;

    @JsonProperty("sistema")
    private String systemName;

    private Process.Status status;

    public ProcessResponseDTO(Process process) {

        this.id = process.getId();
        this.systemName = process.getSystemName();
        this.status = process.getStatus();

    }

}
