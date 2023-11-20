package com.sistemalanchonete.sistemalanchonete.model;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "Catalogos")
public class Catalogo extends Entity {

    @Column(name = "nome", nullable = false)
    private String nome;

    // Relacionamento com Itens_venda
    @ManyToOne
    @JoinColumn(name = "itens_venda", nullable = false)
    private ItensVenda itensVenda;

    public Catalogo() {
    }

    // Construtor com campos
    public Catalogo(String nome, ItensVenda itensVenda) {
        this.nome = nome;
        this.itensVenda = itensVenda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ItensVenda getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(ItensVenda itensVenda) {
        this.itensVenda = itensVenda;
    }
}
