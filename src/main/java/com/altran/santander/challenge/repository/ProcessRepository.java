package com.altran.santander.challenge.repository;

import com.altran.santander.challenge.model.Process;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessRepository extends JpaRepository<Process, Integer> {
}
