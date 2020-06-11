package com.lucasrodrigues.gestao_de_gastos.commands.DTO;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.DBRef;

import com.lucasrodrigues.gestao_de_gastos.domian.Gastos;
import com.lucasrodrigues.gestao_de_gastos.querys.DTO.UsuarioQueryDTO;

public class GastosCommandDTO {

	private String descricao;
	private Double valor;
	private Date data;
	private UsuarioQueryDTO cliente;
	
	
	public GastosCommandDTO(Gastos obj) {
		descricao = obj.getDescricao();
		valor = obj.getValor();
		data = obj.getData();
		cliente = obj.getCliente();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public UsuarioQueryDTO getCliente() {
		return cliente;
	}

	public void setCliente(UsuarioQueryDTO cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		GastosCommandDTO other = (GastosCommandDTO) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
	
	
}
