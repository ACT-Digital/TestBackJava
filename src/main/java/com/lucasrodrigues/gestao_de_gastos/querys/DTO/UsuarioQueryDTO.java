package com.lucasrodrigues.gestao_de_gastos.querys.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lucasrodrigues.gestao_de_gastos.domian.Gastos;
import com.lucasrodrigues.gestao_de_gastos.domian.Usuario;

import io.swagger.annotations.Api;

@Api(value = "Classe para a tansferencia de dados customizado das querys, referente o @Document Usuario")
public class UsuarioQueryDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String codigo;
	private String nome;
	private String email;
	private List<Gastos> gastos = new ArrayList<>();
	
	
	public UsuarioQueryDTO(Usuario obj,Boolean adcLista) {
		this.codigo = obj.getCodigo();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		if(adcLista)
		this.gastos = obj.getGastos();
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

	public List<Gastos> getGastos() {
		return gastos;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioQueryDTO other = (UsuarioQueryDTO) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	
}
