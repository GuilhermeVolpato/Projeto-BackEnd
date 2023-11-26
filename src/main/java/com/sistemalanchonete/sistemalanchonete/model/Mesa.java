package com.sistemalanchonete.sistemalanchonete.model;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "Mesas")
public class Mesa extends Entity {

    @Column(name = "qtde_pessoas", nullable = false)
    private Long qtdePessoas;

    // Relacionamento com Pedido
    @ManyToOne
    @JoinColumn(name = "pedido", nullable = false)
    private Pedido pedido;

    @Column(name = "status", nullable = false)
    private Status status;

    public Mesa() {
        super();
    }

    // Construtor com campos
    public Mesa(Long qtdePessoas, Pedido pedido, Status status) {
        super();
        this.qtdePessoas = qtdePessoas;
        this.pedido = pedido;
        this.status = status;
    }

    public Long getQtdePessoas() {
        return qtdePessoas;
    }

    public void setQtdePessoas(Long qtdePessoas) {
        this.qtdePessoas = qtdePessoas;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
