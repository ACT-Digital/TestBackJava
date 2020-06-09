package com.altran.santander.challenge.model.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestDTO {

    @JsonProperty("descricao")
    private String description;

    @JsonProperty("valor")
    @NotNull(message = "Valor é obrigatório")
    private Double value;

    @JsonProperty("codigousuario")
    @NotNull(message = "Código do Usuário é obrigatório")
    private Integer costumerId;

    @JsonProperty("data")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull(message = "Data é obrigatória")
    private Calendar date;

    @JsonProperty("categoria")
    private String category;

}
