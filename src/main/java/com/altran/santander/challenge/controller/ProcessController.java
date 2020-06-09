package com.altran.santander.challenge.controller;

import com.altran.santander.challenge.model.Process;
import com.altran.santander.challenge.model.dto.request.ProcessRequestDTO;
import com.altran.santander.challenge.model.dto.response.IdResponseDTO;
import com.altran.santander.challenge.model.dto.response.ProcessResponseDTO;
import com.altran.santander.challenge.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Transactional
@RequestMapping("api/process")
public class ProcessController {

    @Autowired
    private ProcessService processService;

    @GetMapping
    public ResponseEntity<List<ProcessResponseDTO>> findAll() {

        return ResponseEntity.ok(processService.findAll()
                .stream()
                .map(ProcessResponseDTO::new)
                .collect(Collectors.toList()));

    }

    @PostMapping
    public ResponseEntity<IdResponseDTO> save(@RequestBody @Valid ProcessRequestDTO processRequestDTO, UriComponentsBuilder uriBuilder) {

        Process process = processService.saveRequest(processRequestDTO);
        URI uri = uriBuilder.build("api/process");
        return ResponseEntity.created(uri).body(new IdResponseDTO(process.getId()));

    }

}
