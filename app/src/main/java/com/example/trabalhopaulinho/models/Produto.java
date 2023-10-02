package com.example.trabalho.models;

public class Produto {

    public String codigo;
    public String descricao;
    public String preco;

    public Produto() {
    }

    public Produto(String codigo, String descricao, String preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
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

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}
