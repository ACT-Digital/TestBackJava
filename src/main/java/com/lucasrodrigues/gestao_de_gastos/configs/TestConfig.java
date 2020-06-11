package com.lucasrodrigues.gestao_de_gastos.configs;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lucasrodrigues.gestao_de_gastos.commands.repository.UsuarioCommandRepository;
import com.lucasrodrigues.gestao_de_gastos.domian.Usuario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Classe de configuração para o perfil test")
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	
	private UsuarioCommandRepository userCommandRepo;
	
	@Autowired
	public TestConfig(UsuarioCommandRepository userCommandRepo) {
		this.userCommandRepo = userCommandRepo;
	}
	
	@ApiOperation(value = "Metodo executado quando a aplicação é iniciada")
	@Override
	public void run(String... args) throws Exception {
		userCommandRepo.deleteAll();
		userCommandRepo.saveAll(getListUsuarios());
		
	}

	private List<Usuario> getListUsuarios(){
		Usuario u1 = new Usuario(null, "leao", "leao@gmail", "1234");
		Usuario u2 = new Usuario(null, "bruno", "bruno@gmail", "1296");
		
		return Arrays.asList(u1,u2);
		
	}
}
