package com.lucasrodrigues.gestao_de_gastos.domian;

import java.io.Serializable;
import java.util.Date;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lucasrodrigues.gestao_de_gastos.querys.DTO.ClienteDTO;

@Document(collection  = "tb_gastos")
public class Gastos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String codigo;
	private String descricao;
	private Double valor;
	private Date data;
	
	private ClienteDTO cliente;
	
	public Gastos() {

	}

	public Gastos(String codigo, String descricao, Double valor, Date data, ClienteDTO cliente) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
		this.cliente = cliente;
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

	@JsonFormat
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
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
