package com.lucasrodrigues.gestao_de_gastos.domian;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.lucasrodrigues.gestao_de_gastos.querys.DTO.UsuarioQueryDTO;

@Document(collection  = "tb_gastos")
public class Gastos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String codigo;
	private String descricao;
	private Double valor;
	private Instant data;
	@DBRef(lazy = true)
	private UsuarioQueryDTO cliente;
	
	public Gastos() {

	}

	public Gastos(String codigo, String descricao, Double valor, Instant data,UsuarioQueryDTO cliente) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public Instant getData() {
		return data;
	}

	public void setData(Instant data) {
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
		Gastos other = (Gastos) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
