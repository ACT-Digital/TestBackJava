package com.lucasrodrigues.gestao_de_gastos.querys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasrodrigues.gestao_de_gastos.domian.Usuario;
import com.lucasrodrigues.gestao_de_gastos.querys.repository.UsuarioQueryRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Classe de serviço para fazer querys dos usuarios")
@Service
public class UsuarioQueryService {

	private UsuarioQueryRepository userQueryRepo;
	
	@Autowired
	public UsuarioQueryService(UsuarioQueryRepository userQueryRepo) {
		this.userQueryRepo = userQueryRepo;
	}
	
	@ApiOperation(value = "Retorna uma lista do Tipo Usuario")
	synchronized public List<Usuario>findAll(){
		return userQueryRepo.findAll();
	}
}
