package com.sistemalanchonete.sistemalanchonete.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@javax.persistence.Entity
@Table(name = "Ingredientes")
public class Ingrediente extends Entity {
    @JoinColumn(name = "estoque_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Estoque> estoques;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "quantidade_total", nullable = false)
    private Double quantidadeTotal;

    @Column(name = "quantidade_minima", nullable = false)
    private Double quantidadeMinima;

    @Column(name = "quantidade_atual", nullable = false)
    private Double quantidadeAtual;


    @Column(name = "dt_validade", nullable = false)
    private Date dtValidade;

    @Column(name = "preço_compra", nullable = false)
    private Double precoCompra;

    @Column(name = "temperatura_armazenamento", nullable = false)
    private Double temperaturaArmazenamento;



    public Ingrediente() {
        super();
        this.estoques = new ArrayList<>(); // Initialize the list
    }

    // Construtor com campos
    public Ingrediente(String nome, Double quantidadeTotal, Double quantidadeMinima, Date dtValidade, Double precoCompra, Double temperaturaArmazenamento, Estoque estoque) {
        super(nome, quantidadeTotal,quantidadeMinima,dtValidade,precoCompra,temperaturaArmazenamento);
        this.estoques = new ArrayList<>(List.of(estoque));
    }
    private String formatarEstoque() {
        if (estoques != null && !estoques.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Estoque estoque : estoques) {
                sb.append(estoque.toString()).append("; ");
            }
            return sb.toString();
        }
        return "Sem estoque";
    }
    public List<Estoque> getEstoque() { return estoques;
    }
    // Correção aqui - utilize um método específico para setar os endereços
    public void setEnderecos(List<Estoque> estoque) {this.estoques = estoque; }

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

    public List<Estoque> getEstoques() {
        return estoques;
    }

    public void setEstoques(List<Estoque> estoques) {
        this.estoques = estoques;
    }

    public Double getQuantidadeAtual() {
        return quantidadeAtual;
    }

    public void setQuantidadeAtual(Double quantidadeAtual) {
        this.quantidadeAtual = quantidadeAtual;
    }


}
