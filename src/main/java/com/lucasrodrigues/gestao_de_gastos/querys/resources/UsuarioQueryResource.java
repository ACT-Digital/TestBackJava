package com.lucasrodrigues.gestao_de_gastos.querys.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasrodrigues.gestao_de_gastos.domian.Usuario;
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
	public ResponseEntity<List<Usuario>> findAll(){
		
		List<Usuario> result = userQueryService.findAll();
		return ResponseEntity.ok().body(result);
	}
}
