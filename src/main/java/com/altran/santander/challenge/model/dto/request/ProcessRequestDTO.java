package com.altran.santander.challenge.model.dto.request;

import com.altran.santander.challenge.model.Process;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessRequestDTO implements Serializable {

    @JsonProperty("sistema")
    private String systemName;

    private Process.Status status;

}
