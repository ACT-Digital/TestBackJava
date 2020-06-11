package com.lucasrodrigues.gestao_de_gastos.commands.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasrodrigues.gestao_de_gastos.commands.repository.GastosCommandRepository;

import io.swagger.annotations.Api;

@Api(value = "Classe de serviço para fazer inserção de dados dos gastos")
@Service
public class UsuarioCommandService {

private GastosCommandRepository gastosCommandRepo;
	
	@Autowired
	public UsuarioCommandService(GastosCommandRepository gastosCommandRepo) {
		this.gastosCommandRepo = gastosCommandRepo;
	}
	
	
}
