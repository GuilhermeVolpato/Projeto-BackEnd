package com.sistemalanchonete.sistemalanchonete.model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho extends Entity{
    private Cliente cliente;
    private List<ItemCarrinho> itens = new ArrayList<>();

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addItemCarrinho(ItemCarrinho item) {
        item.setCarrinho(this);
        this.itens.add(item);
    }

    public void delItemCarrinho(ItemCarrinho item) {
        this.itens.remove(item);
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }
}
