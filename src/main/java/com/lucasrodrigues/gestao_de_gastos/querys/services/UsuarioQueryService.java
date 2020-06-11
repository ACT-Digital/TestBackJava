package com.lucasrodrigues.gestao_de_gastos.querys.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasrodrigues.gestao_de_gastos.domian.Usuario;
import com.lucasrodrigues.gestao_de_gastos.querys.repository.UsuarioQueryRepository;
import com.lucasrodrigues.gestao_de_gastos.querys.services.exceptions.ResourceNotFoundException;

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
	
	@ApiOperation(value = "Retorna um objeto do Tipo Usuario")
	synchronized public Usuario findById(String id){
		Optional<Usuario> opUser= userQueryRepo.findById(id);
		return  opUser.orElseThrow(()->new ResourceNotFoundException("Objeto nao encontrado"));
	}
	
	@ApiOperation(value = "Insere um Usuario")
	synchronized public Usuario insert(Usuario usuario){
		Optional<Usuario> opUser= userQueryRepo.findById(id);
		return  opUser.orElseThrow(()->new ResourceNotFoundException("Objeto nao encontrado"));
	}
}
