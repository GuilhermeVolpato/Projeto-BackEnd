package com.sistemalanchonete.sistemalanchonete.model;

import java.time.LocalDate;

public class Ingrediente extends Entity{
    private String nome;
    private Integer diasValidade;
    private Situacao situacao;
    private Double precoCompra;
    private Double temperaturaEstoque;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDiasValidade() {
        return diasValidade;
    }

    public void setDiasValidade(Integer diasValidade) {
        this.diasValidade = diasValidade;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Double getTemperaturaEstoque() {
        return temperaturaEstoque;
    }

    public void setTemperaturaEstoque(Double temperaturaEstoque) {
        this.temperaturaEstoque = temperaturaEstoque;
    }
}
