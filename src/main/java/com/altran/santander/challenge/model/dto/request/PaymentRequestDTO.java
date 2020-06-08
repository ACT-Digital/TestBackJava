package com.altran.santander.challenge.model.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestDTO {

    @JsonProperty("descricao")
    private String description;

    @JsonProperty("valor")
    private Double value;

    @JsonProperty("codigousuario")
    private Integer costumerId;

    @JsonProperty("data")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Calendar date;

    @JsonProperty("categoria")
    private String category;

}
