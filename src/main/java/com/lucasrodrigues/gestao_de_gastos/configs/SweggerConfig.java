package com.lucasrodrigues.gestao_de_gastos.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Api(value = "Classe de configuracao para o Swagger")
@Configuration
@EnableSwagger2
public class SweggerConfig {

	@ApiOperation(value = "Configura o padrão para o Swagger")
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2) //
				.select() //
				.apis(RequestHandlerSelectors.any())// todos os pacotes disponivies
				.paths(PathSelectors.any()) // todos os end points estarao dispponiveis
				.build() //
				.apiInfo(apiInfo()); //

	}

	@ApiOperation(value = "Gera as informações da API")
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Gestao de gastos SpringBoot REST API ") //
				.description("Spring Boot REST API, para gerênciar os gastos de um usuário cadastrado") //
				.version("1.0.0") //
				.license("Apache License Version 2.0") //
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0") //
				.contact(new springfox.documentation.service.Contact("Lucas Rodrigues",
						"https://github.com/lucasrodrigues19/", "lucasp.rodrigues@uni9.edu.br"))//
				.build();
	}
}
