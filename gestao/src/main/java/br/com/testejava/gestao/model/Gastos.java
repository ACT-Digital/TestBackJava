package br.com.testejava.gestao.model;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Date;


public class Gastos implements Serializable {
    private static final long serialVersionUID = 1L;


    private String descricao;
    private double valor;
    private Date data;
    private String categoria;

    public Gastos(String descricao, double valor, Date data, Categoria categoria) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.categoria = categoria == null ? null : categoria.getTipo_categoria();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append('{');
        sb.append("descricao='").append(descricao).append('\'');
        sb.append(", valor=").append(valor);
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }


    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }


}
