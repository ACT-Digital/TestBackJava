package com.altran.santander.challenge.controller;

import com.altran.santander.challenge.model.Company;
import com.altran.santander.challenge.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@Transactional
@RequestMapping("api/company")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping
    public List<Company> findAll() {

        return companyRepository.findAll();

    }

    @PostMapping
    public ResponseEntity<Company> save(@RequestBody Company company, UriComponentsBuilder uriBuilder) {

        companyRepository.save(company);
        URI uri = uriBuilder.build("api/company");
        return ResponseEntity.created(uri).body(company);

    }

}
