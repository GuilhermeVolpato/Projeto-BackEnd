package com.sistemalanchonete.sistemalanchonete.model;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "Feedback")
public class Feedback extends Entity {

    @Column(name = "isAnonimo", nullable = false)
    private Boolean isAnonimo;

    @Column(name = "observacao", nullable = false)
    private String observacao;

    // Relacionamento com Cliente
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    // Construtores, getters e setters

    // Regra de Negócio: Feedback dos Produtos
    private String comentario;
    private int avaliacao;

    // Métodos de acesso e manipulação dos atributos

    // Exemplo de construtor vazio para JPA
    public Feedback() {
        super();
    }

    // Construtor com campos
    public Feedback(Boolean isAnonimo, String observacao, Cliente cliente) {
        super();
        this.isAnonimo = isAnonimo;
        this.observacao = observacao;
        this.cliente = cliente;
    }

    // Getters e setters

    public Boolean getIsAnonimo() {
        return isAnonimo;
    }

    public void setIsAnonimo(Boolean isAnonimo) {
        this.isAnonimo = isAnonimo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
