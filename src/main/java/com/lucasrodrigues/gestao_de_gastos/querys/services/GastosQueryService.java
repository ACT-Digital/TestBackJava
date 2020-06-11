package com.lucasrodrigues.gestao_de_gastos.querys.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasrodrigues.gestao_de_gastos.domian.Gastos;
import com.lucasrodrigues.gestao_de_gastos.querys.repository.GastosQueryRepository;
import com.lucasrodrigues.gestao_de_gastos.querys.services.exceptions.ResourceNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Classe de serviço para fazer querys dos usuarios")
@Service
public class GastosQueryService {

	private GastosQueryRepository gastosQueryRepo;
	
	@Autowired
	public GastosQueryService(GastosQueryRepository gastosQueryRepo) {
		this.gastosQueryRepo = gastosQueryRepo;
	}
	
	@ApiOperation(value = "Retorna uma lista do Tipo Gastos")
	synchronized public List<Gastos>findAll(){
		return gastosQueryRepo.findAll();
	}
	
	@ApiOperation(value = "Retorna um objeto do Tipo Gastos")
	synchronized public Gastos findById(String id){
		Optional<Gastos> opUser= gastosQueryRepo.findById(id);
		return  opUser.orElseThrow(()->new ResourceNotFoundException("Objeto nao encontrado"));
	}
	
	
}
