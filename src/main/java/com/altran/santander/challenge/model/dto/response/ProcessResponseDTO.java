package com.altran.santander.challenge.model.dto.response;

import com.altran.santander.challenge.model.Process;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessResponseDTO implements Serializable {

    private Integer id;
    private String sistema;
    private Process.Status status;

    public ProcessResponseDTO(Process process) {

        this.id = process.getId();
        this.sistema = process.getSystemName();
        this.status = process.getStatus();

    }

}
