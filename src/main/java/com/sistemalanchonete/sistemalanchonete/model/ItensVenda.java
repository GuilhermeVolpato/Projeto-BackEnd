package com.sistemalanchonete.sistemalanchonete.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@javax.persistence.Entity
@Table(name = "Itens_venda")
public class ItensVenda extends Entity {

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "valor_custo", nullable = false)
    private Double valorCusto;

    @Column(name = "valor_venda", nullable = false)
    private Double valorVenda;

    // Relacionamento com Ingredientes
    @ManyToOne
    @JoinColumn(name = "ingredientes", nullable = false)
    private Ingrediente ingredientes;

    @Column(name = "observacao", nullable = false)
    private String observacao;

    @Column(name = "is_off", nullable = true, columnDefinition = "boolean default false")
    private Boolean isOff;

    @Column(name = "valor_desconto", nullable = false)
    private Double valorDesconto;

    @Column(name = "dt_inicio_desconto", nullable = false)
    private Date dtInicioDesconto;

    @Column(name = "dt_fim_desconto", nullable = false)
    private Date dtFimDesconto;

    public ItensVenda() {
        super();
    }


    // Construtor com campos
    public ItensVenda(String nome, String descricao, Double valorCusto, Double valorVenda, Ingrediente ingredientes, String observacao, Boolean isOff, Double valorDesconto, Date dtInicioDesconto, Date dtFimDesconto, ItemPedido itemPedido) {
        super();
        this.nome = nome;
        this.descricao = descricao;
        this.valorCusto = valorCusto;
        this.valorVenda = valorVenda;
        this.ingredientes = ingredientes;
        this.observacao = observacao;
        this.isOff = isOff;
        this.valorDesconto = valorDesconto;
        this.dtInicioDesconto = dtInicioDesconto;
        this.dtFimDesconto = dtFimDesconto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(Double valorCusto) {
        this.valorCusto = valorCusto;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Ingrediente getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Ingrediente ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Boolean getOff() {
        return isOff;
    }

    public void setOff(Boolean off) {
        isOff = off;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public Date getDtInicioDesconto() {
        return dtInicioDesconto;
    }

    public void setDtInicioDesconto(Date dtInicioDesconto) {
        this.dtInicioDesconto = dtInicioDesconto;
    }

    public Date getDtFimDesconto() {
        return dtFimDesconto;
    }

    public void setDtFimDesconto(Date dtFimDesconto) {
        this.dtFimDesconto = dtFimDesconto;
    }
}
