package com.lucasrodrigues.gestao_de_gastos.commands.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasrodrigues.gestao_de_gastos.commands.DTO.UsuarioCommandDTO;
import com.lucasrodrigues.gestao_de_gastos.commands.repository.UsuarioCommandRepository;
import com.lucasrodrigues.gestao_de_gastos.domian.Usuario;

import io.swagger.annotations.Api;

@Api(value = "Classe de serviço para fazer inserção de dados dos gastos")
@Service
public class UsuarioCommandService {

private UsuarioCommandRepository userCommandRepo;
	
	@Autowired
	public UsuarioCommandService(UsuarioCommandRepository userCommandRepo) {
		this.userCommandRepo = userCommandRepo;
	}
	

	public Usuario fromDTO(UsuarioCommandDTO obj) {
		Usuario user = new Usuario();
		user.setEmail(obj.getEmail());
		user.setNome(obj.getNome());
		user.setSenha(obj.getSenha());
		user.getGastos().addAll(obj.getGastos());
		return user;
	}
}
