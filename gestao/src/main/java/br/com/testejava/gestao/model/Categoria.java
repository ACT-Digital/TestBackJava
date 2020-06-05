package br.com.testejava.gestao.model;

import java.io.Serializable;

public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;

    private String tipo_categoria;

    public Categoria(String tipo_categoria) {
        this.tipo_categoria = tipo_categoria;
    }

    public String getTipo_categoria() {
        return tipo_categoria;
    }

    public void setTipo_categoria(String tipo_categoria) {
        this.tipo_categoria = tipo_categoria;
    }
}
