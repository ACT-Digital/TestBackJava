package com.altran.santander.challenge.model;

import com.altran.santander.challenge.model.dto.request.ProcessRequestDTO;
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
public class Process implements Serializable {

    @Id
    @SequenceGenerator(name = "processSequence", sequenceName = "process_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "processSequence")
    @Column(length = 6)
    private Integer id;

    @Column(name = "system_name", length = 30, nullable = false)
    private String systemName;

    @Column
    private Status status;

    @OneToMany(mappedBy = "process")
    private List<Customer> customers;

    public enum Status {
        OK, IRREGULAR
    }

    public Process(ProcessRequestDTO processRequestDTO) {

        this.systemName = processRequestDTO.getSystemName();
        this.status = processRequestDTO.getStatus();

    }

}
