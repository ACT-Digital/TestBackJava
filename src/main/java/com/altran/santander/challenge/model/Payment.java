package com.altran.santander.challenge.model;

import com.altran.santander.challenge.model.dto.request.PaymentRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
    private Date date;

    @Column(length = 30)
    private String category;

    @ManyToOne
    @JoinColumn(name = "id_customer", nullable = false, foreignKey = @ForeignKey(name = "fk_customer_payment"))
    private Customer customer;

    public Payment(PaymentRequestDTO paymentRequestDTO) {

        this.value = paymentRequestDTO.getValor();
        this.description = paymentRequestDTO.getDescricao();
        this.date = paymentRequestDTO.getData();

    }

}
