package com.altran.santander.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer implements Serializable {

    @Id
    @SequenceGenerator(name = "customerSequence", sequenceName = "customer_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "customerSequence")
    @Column(length = 8)
    private Integer id;

    @Column(length = 45, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_company", nullable = false, foreignKey = @ForeignKey(name = "fk_company_customer"))
    private Company company;

    @OneToMany(mappedBy = "customer")
    private List<Payment> payments;

}
