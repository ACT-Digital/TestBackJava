package com.lucasrodrigues.gestao_de_gastos.querys.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasrodrigues.gestao_de_gastos.domian.Usuario;
import com.lucasrodrigues.gestao_de_gastos.querys.DTO.UsuarioQueryDTO;
import com.lucasrodrigues.gestao_de_gastos.querys.services.UsuarioQueryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "EndPoint para as query do usuario")
@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioQueryResource {

	private UsuarioQueryService userQueryService;

	@Autowired
	public UsuarioQueryResource(UsuarioQueryService userQueryService) {
		this.userQueryService = userQueryService;
	}
	
	@ApiOperation(value = "EndPoint 'Raiz' dos usuarios")
	@GetMapping
	public String index(){
	   return getPassosAPI();
	}
	
	@ApiOperation(value = "Retorna uma lista do tipo UsuarioQueryDTO com todos os usuarios")
	@GetMapping(value = "/findall")
	public ResponseEntity<List<UsuarioQueryDTO>> findAll(){
		List<UsuarioQueryDTO> result = userQueryService.findAll().stream().map( x -> new UsuarioQueryDTO(x,true)).collect(Collectors.toList());
		return ResponseEntity.ok().body(result);
	}
	@ApiOperation(value = "Retorna um objeto  do tipo UsuarioQueryDTO ")
	@GetMapping(value = "/{id}")
	public ResponseEntity <UsuarioQueryDTO> findById(@PathVariable String id){
		Usuario user = userQueryService.findById(id);
		UsuarioQueryDTO result = new UsuarioQueryDTO(user,true);
		return ResponseEntity.ok().body(result);
	}
	
	
	
	
	
	
	
	
	
	
	@ApiOperation(value = "Retorna uma Stirng com um tutorial para ultilizar a API")
    private String getPassosAPI() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("<body style='font-family: arial , sans-serif;'>");
    	sb.append("<h2> TUTORIAL PARA ULTILIZAR A API DE <span style='color: green'>GESTÃO DE GASTOS</span> </h2>");
    	sb.append("<h4>{} -> informe um valor</h4>");
    	
    	sb.append("<h3>Executar com Swagger</h3>");
    	sb.append("<p>http://localhost:8080/swagger-ui.html#/usuarios/ -> endPoint raiz do usuario</p>\n");
    	sb.append("<p>http://localhost:8080/swagger-ui.html#/usuarios/findall ->  retorna um JSON com todos os usuarios\n</p>");
    	sb.append("<p>http://localhost:8080/swagger-ui.html#/usuarios/{seuid} ->  retorna um JSON com um usuario\n</p>");
    	sb.append("\n<br>" ); 
    	sb.append("<h3>Sem o Swagger\n</h3>" );
    	sb.append("<p>http://localhost:8080/usuarios/ -> endPoint raiz do usuario\n</p>");
    	sb.append("<p>http://localhost:8080/usuarios/findall -> retorna um JSON com todos os usuarios\n</p>");
    	sb.append("<p>http://localhost:8080/usuarios/{seuid} ->  retorna um JSON com um usuario\n</p>");
    	sb.append("</body>");
    	return sb.toString();
    }
}
