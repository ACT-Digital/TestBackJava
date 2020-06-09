package com.altran.santander.challenge.service;

import com.altran.santander.challenge.model.Process;
import com.altran.santander.challenge.model.dto.request.ProcessRequestDTO;
import com.altran.santander.challenge.repository.ProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessService {

    @Autowired
    private ProcessRepository processRepository;

    public List<Process> findAll() {

        return processRepository.findAll();

    }

    public Process save(Process process) {

        return processRepository.save(process);

    }

    public Process saveRequest(ProcessRequestDTO processRequestDTO) {

        Process process = new Process(processRequestDTO);
        return this.save(process);

    }

    public Process findById(Integer id) {

        return processRepository.findById(id).orElse(null);

    }

}
