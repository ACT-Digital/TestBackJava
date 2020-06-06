package com.altran.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @SequenceGenerator(name = "customerSequence", sequenceName = "customer_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "customerSequence")
    @Column(length = 8)
    private Integer id;

    @Column(length = 45)
    private String name;

    @Column(length = 50)
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Payment> payments;

    @ManyToOne
    @JoinColumn(name = "id_company", foreignKey = @ForeignKey(name = "fk_company_customer"))
    private Company company;

}
