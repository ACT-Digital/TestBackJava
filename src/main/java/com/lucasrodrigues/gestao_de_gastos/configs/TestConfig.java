package com.lucasrodrigues.gestao_de_gastos.configs;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lucasrodrigues.gestao_de_gastos.commands.repository.GastosCommandRepository;
import com.lucasrodrigues.gestao_de_gastos.commands.repository.UsuarioCommandRepository;
import com.lucasrodrigues.gestao_de_gastos.domian.Gastos;
import com.lucasrodrigues.gestao_de_gastos.domian.Usuario;
import com.lucasrodrigues.gestao_de_gastos.querys.DTO.UsuarioQueryDTO;
import com.lucasrodrigues.gestao_de_gastos.utils.DataUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Classe de configuração para o perfil test")
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	
	private UsuarioCommandRepository userCommandRepo;
	private GastosCommandRepository gastosCommandRepo;
	
	@Autowired
	public TestConfig(UsuarioCommandRepository userCommandRepo,GastosCommandRepository gastosCommandRepo) {
		this.userCommandRepo = userCommandRepo;
		this.gastosCommandRepo = gastosCommandRepo;
	}
	
	@ApiOperation(value = "Metodo executado quando a aplicação é iniciada")
	@Override
	public void run(String... args) throws Exception {
		
		userCommandRepo.deleteAll();
		Usuario u1 = new Usuario(null, "leao", "leao@gmail", "1234");
		Usuario u2 = new Usuario(null, "bruno", "bruno@gmail", "1296");
		userCommandRepo.saveAll( Arrays.asList(u1,u2));
		
		gastosCommandRepo.deleteAll();
		Gastos g1 = new Gastos(null, "super mercado sp", 40.00, DataUtil.convert("2020-06-11", DataUtil.UTC), new UsuarioQueryDTO(u1,false));
		Gastos g2 = new Gastos(null, "empregado", 998.00, DataUtil.convert("2020-04-04", DataUtil.UTC), new UsuarioQueryDTO(u1,false));
	
		gastosCommandRepo.saveAll(Arrays.asList(g1,g2));
		
		u1.getGastos().addAll(Arrays.asList(g1,g2));
		userCommandRepo.saveAll( Arrays.asList(u1,u2));
		
		
	}


	}
