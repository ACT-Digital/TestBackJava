package com.lucasrodrigues.gestao_de_gastos.querys.services.exceptions;

import io.swagger.annotations.Api;

@Api(value = "Excecao personalizada para recursos não encontrados")
public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("Resourse not found. Id "+ id);
	}
}
