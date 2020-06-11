package com.lucasrodrigues.gestao_de_gastos.commands.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lucasrodrigues.gestao_de_gastos.domian.Gastos;

public interface GastosCommandRepository extends MongoRepository<Gastos, String>{

	
}
