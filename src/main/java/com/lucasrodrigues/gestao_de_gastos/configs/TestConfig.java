package com.lucasrodrigues.gestao_de_gastos.configs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Classe de configuração para o perfil test")
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@ApiOperation(value = "Metodo executado quando a aplicação é iniciada")
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
