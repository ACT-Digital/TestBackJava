package com.altran.santander.challenge.model;

import com.altran.santander.challenge.model.dto.request.CardPaymentIntegrationRequestDTO;
import com.altran.santander.challenge.model.dto.request.PaymentRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment implements Serializable {

    @Id
    @SequenceGenerator(name = "paymentSequence", sequenceName = "payment_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "paymentSequence")
    @Column(length = 10)
    private Integer id;

    @Column(length = 10, precision = 2, nullable = false)
    private Double value;

    @Column(length = 100)
    private String description;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Calendar date;

    @Column(length = 30)
    private String category;

    @ManyToOne
    @JoinColumn(name = "id_customer", nullable = false, foreignKey = @ForeignKey(name = "fk_customer_payment"))
    private Customer customer;

    public Payment(CardPaymentIntegrationRequestDTO cardPaymentIntegrationRequestDTO) {

        this.value = cardPaymentIntegrationRequestDTO.getValue();
        this.description = cardPaymentIntegrationRequestDTO.getDescription();
        this.date = cardPaymentIntegrationRequestDTO.getDate();

    }

    public Payment(PaymentRequestDTO paymentRequestDTO) {

        this.value = paymentRequestDTO.getValue();
        this.description = paymentRequestDTO.getDescription();
        this.date = paymentRequestDTO.getDate();
        this.category = paymentRequestDTO.getCategory();

    }

}
