package com.sistemalanchonete.sistemalanchonete.model;

public class ReceitaItem extends Entity{
    private ItemsMenu produto;
    private Ingrediente ingrediente;
    private Double quantidade;
    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public ItemsMenu getProduto() {
        return produto;
    }

    public void setProduto(ItemsMenu produto) {
        this.produto = produto;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
}
