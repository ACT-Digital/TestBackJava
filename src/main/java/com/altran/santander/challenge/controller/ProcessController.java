package com.altran.santander.challenge.controller;

import com.altran.santander.challenge.model.Process;
import com.altran.santander.challenge.repository.ProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@Transactional
@RequestMapping("api/process")
public class ProcessController {

    @Autowired
    private ProcessRepository processRepository;

    @GetMapping
    public List<Process> findAll() {

        return processRepository.findAll();

    }

    @PostMapping
    public ResponseEntity<Process> save(@RequestBody Process process, UriComponentsBuilder uriBuilder) {

        processRepository.save(process);
        URI uri = uriBuilder.build("api/process");
        return ResponseEntity.created(uri).body(process);

    }

}
