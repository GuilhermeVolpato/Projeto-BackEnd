package com.sistemalanchonete.sistemalanchonete.model;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
public class ItemsMenu extends Entity{
    @Column(name = "preco_venda")
    private Double precoVenda;

    @Column(name = "nome")
    private String nome;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "situacao")
//    private Situacao situacao;

    private List<ReceitaItem> itens = new ArrayList<>();

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

//    public Situacao getSituacao() {
//        return situacao;
//    }
//
//    public void setSituacao(Situacao situacao) {
//        this.situacao = situacao;
//    }

    public void addItemReceita(ReceitaItem item) {
        item.setProduto(this);
        this.itens.add(item);
    }

    public void delItemReceita(ReceitaItem item) {
        this.itens.remove(item);
    }

    public List<ReceitaItem> getItens() {
        return itens;
    }
}
