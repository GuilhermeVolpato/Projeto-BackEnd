package com.sistemalanchonete.sistemalanchonete.model;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "Item_pedido")
public class ItemPedido extends Entity {

    // Relacionamento com Itens_venda
    @ManyToOne
    @JoinColumn(name = "item", nullable = false)
    private ItensVenda item;

    // Relacionamento com Pedido
    @ManyToOne
    @JoinColumn(name = "pedido", nullable = false)
    private Pedido pedido;

    @Column(name = "qtde", nullable = false)
    private Long qtde;

    public ItemPedido() {
    }

    // Construtor com campos
    public ItemPedido(ItensVenda item, Pedido pedido, Long qtde) {
        this.item = item;
        this.pedido = pedido;
        this.qtde = qtde;
    }

    public ItensVenda getItem() {
        return item;
    }

    public void setItem(ItensVenda item) {
        this.item = item;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Long getQtde() {
        return qtde;
    }

    public void setQtde(Long qtde) {
        this.qtde = qtde;
    }
}
