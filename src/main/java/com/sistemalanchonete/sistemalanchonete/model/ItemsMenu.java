package com.sistemalanchonete.sistemalanchonete.model;

import java.util.ArrayList;
import java.util.List;

public class ItemsMenu extends Entity{
    private Double precoVenda;
    private String nome;
    private Situacao situacao;
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

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

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
