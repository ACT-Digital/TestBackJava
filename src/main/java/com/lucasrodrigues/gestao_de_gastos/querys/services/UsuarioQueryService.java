package com.lucasrodrigues.gestao_de_gastos.querys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasrodrigues.gestao_de_gastos.domian.Usuario;
import com.lucasrodrigues.gestao_de_gastos.querys.repository.UsuarioQueryRepository;

@Service
public class UsuarioQueryService {

	private UsuarioQueryRepository userQueryRepo;
	
	@Autowired
	public UsuarioQueryService(UsuarioQueryRepository userQueryRepo) {
		this.userQueryRepo = userQueryRepo;
	}
	
	public List<Usuario>findAll(){
		return userQueryRepo.findAll();
	}
}
