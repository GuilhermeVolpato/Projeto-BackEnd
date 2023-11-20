package com.sistemalanchonete.sistemalanchonete.model;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "Estoque")
public class Estoque extends Entity {

    // Relacionamento com Compartimentos
    @ManyToOne
    @JoinColumn(name = "código_compartimento", nullable = false)
    private Compartimento compartimento;

    @Column(name = "qtde_ingredientes", nullable = false)
    private Long qtdeIngredientes;

    public Estoque() {
    }

    // Construtor com campos
    public Estoque(Compartimento compartimento, Long qtdeIngredientes) {
        this.compartimento = compartimento;
        this.qtdeIngredientes = qtdeIngredientes;
    }

    public Compartimento getCompartimento() {
        return compartimento;
    }

    public void setCompartimento(Compartimento compartimento) {
        this.compartimento = compartimento;
    }

    public Long getQtdeIngredientes() {
        return qtdeIngredientes;
    }

    public void setQtdeIngredientes(Long qtdeIngredientes) {
        this.qtdeIngredientes = qtdeIngredientes;
    }
}
