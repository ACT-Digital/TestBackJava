package com.lucasrodrigues.gestao_de_gastos.querys.DTO;

import java.io.Serializable;

import com.lucasrodrigues.gestao_de_gastos.domian.Usuario;

import io.swagger.annotations.Api;

@Api(value = "Classe para a tansferencia de dados customizado das querys, referente o @Document Usuario")
public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String codigo;
	private String nome;
	private String email;

	public ClienteDTO() {
		
	}
	
	public ClienteDTO(Usuario obj) {
		if (obj != null) {
			this.codigo = obj.getCodigo();
			this.nome = obj.getNome();
			this.email = obj.getEmail();
		}
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
