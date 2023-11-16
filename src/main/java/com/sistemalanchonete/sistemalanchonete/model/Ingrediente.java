package com.sistemalanchonete.sistemalanchonete.model;

import javax.persistence.*;
import java.util.Date;

@javax.persistence.Entity
@Table(name = "Ingredientes")
public class Ingrediente extends Entity {

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "quantidade_total", nullable = false)
    private Double quantidadeTotal;

    @Column(name = "quantidade_minima", nullable = false)
    private Double quantidadeMinima;

    @Column(name = "dt_validade", nullable = false)
    private Date dtValidade;

    @Column(name = "preço_compra", nullable = false)
    private Double precoCompra;

    @Column(name = "temperatura_armazenamento", nullable = false)
    private Double temperaturaArmazenamento;

    public Ingrediente() {
    }

    // Construtor com campos
    public Ingrediente(String nome, Double quantidadeTotal, Double quantidadeMinima, Date dtValidade, Double precoCompra, Double temperaturaArmazenamento) {
        this.nome = nome;
        this.quantidadeTotal = quantidadeTotal;
        this.quantidadeMinima = quantidadeMinima;
        this.dtValidade = dtValidade;
        this.precoCompra = precoCompra;
        this.temperaturaArmazenamento = temperaturaArmazenamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(Double quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public Double getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(Double quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public Date getDtValidade() {
        return dtValidade;
    }

    public void setDtValidade(Date dtValidade) {
        this.dtValidade = dtValidade;
    }

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Double getTemperaturaArmazenamento() {
        return temperaturaArmazenamento;
    }

    public void setTemperaturaArmazenamento(Double temperaturaArmazenamento) {
        this.temperaturaArmazenamento = temperaturaArmazenamento;
    }
}
