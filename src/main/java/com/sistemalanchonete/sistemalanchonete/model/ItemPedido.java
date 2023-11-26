package com.sistemalanchonete.sistemalanchonete.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
@Table(name = "Item_pedido")
public class ItemPedido extends Entity {

    @JoinColumn(name = "ItemVenda_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItensVenda> itensVendas;

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
        super();
        this.itensVendas = new ArrayList<>(); // Initialize the list
    }

    // Construtor com campos
    public ItemPedido(ItensVenda item, Pedido pedido, Long qtde,ItensVenda itensVenda) {
        super(item,pedido,qtde);
        this.itensVendas = new ArrayList<>(List.of(itensVenda));
    }
    private String formatarItemVenda() {
        if (itensVendas != null && !itensVendas.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ItensVenda itensVenda: itensVendas) {
                sb.append(itensVenda.toString()).append("; ");
            }
            return sb.toString();
        }
        return "Sem itens venda";
    }
    public List<ItensVenda> getItensvendas() { return itensVendas;
    }
    // Correção aqui - utilize um método específico para setar os endereços
    public void setItensVendas(List<ItensVenda> itensVendas) {this.itensVendas = itensVendas; }


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
