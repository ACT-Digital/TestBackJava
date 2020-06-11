package com.lucasrodrigues.gestao_de_gastos.querys.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasrodrigues.gestao_de_gastos.querys.DTO.UsuarioQueryDTO;
import com.lucasrodrigues.gestao_de_gastos.querys.services.UsuarioQueryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "endPoint para as query do usuario")
@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioQueryResource {

	private UsuarioQueryService userQueryService;

	@Autowired
	public UsuarioQueryResource(UsuarioQueryService userQueryService) {
		this.userQueryService = userQueryService;
	}
	
	@ApiOperation(value = "Retorna uma lista com todos os usuarios")
	@GetMapping
	public ResponseEntity<List<UsuarioQueryDTO>> findAll(){
		
		List<UsuarioQueryDTO> result = userQueryService.findAll().stream().map( x -> new UsuarioQueryDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(result);
	}
}
