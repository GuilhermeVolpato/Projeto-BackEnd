package com.sistemalanchonete.sistemalanchonete.model;

import java.time.LocalDate;

public class Estoque extends Entity{
    private Double quantidade;
    private LocalDate dt_previzao;
    private ItemsMenu produto;

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDt_previzao() {
        return dt_previzao;
    }

    public void setDt_previzao(LocalDate dt_previzao) {
        this.dt_previzao = dt_previzao;
    }

    public ItemsMenu getProduto() {
        return produto;
    }

    public void setProduto(ItemsMenu produto) {
        this.produto = produto;
    }
}
