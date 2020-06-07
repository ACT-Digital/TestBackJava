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
public class Company {

    @Id
    @SequenceGenerator(name = "companySequence", sequenceName = "company_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "companySequence")
    @Column(length = 6)
    private Integer id;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 16, nullable = false)
    private String login;

    @Column(length = 16, nullable = false)
    private String password;

    @OneToMany(mappedBy = "company")
    private List<Customer> customers;

}
