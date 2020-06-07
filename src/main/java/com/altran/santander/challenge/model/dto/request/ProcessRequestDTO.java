package com.altran.santander.challenge.model.dto.request;

import com.altran.santander.challenge.model.Process;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessRequestDTO implements Serializable {

    private String sistema;
    private Process.Status status;

}
