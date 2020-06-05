package br.com.testejava.gestao.model;

import java.io.Serializable;
import java.util.Date;


public class Gastos implements Serializable {
    private static final long serialVersionUID = 1L;

    private String descricao;
    private double valor;
    private String data;
    private String categoria;

    public Gastos(String descricao, double valor, String data, String categoria) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = dataFormat(data);
        this.categoria = categoria;
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

    public static String dataFormat(String dt) {
        StringBuilder formate = new StringBuilder();
        if (dt.length() == 7) {
            formate = formate.append("0").append(dt,0, 2);
            formate.append("/").append(dt,2, 4);
            formate.append("/").append(dt,4, 8);
        }else if (dt.length() == 8){
            formate.append(dt,0, 2);
            formate.append("/").append(dt, 2, 4);
            formate.append("/").append(dt,4, 8);
        }else{
            return "Data invalida";
        }
        return formate.toString();
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


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = dataFormat(data);
    }


}
