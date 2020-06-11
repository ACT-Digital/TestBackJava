package com.lucasrodrigues.gestao_de_gastos.querys.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lucasrodrigues.gestao_de_gastos.domian.Gastos;

public interface GastosQueryRepository extends MongoRepository<Gastos, String>{

	
}
