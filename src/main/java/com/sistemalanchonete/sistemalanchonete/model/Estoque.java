package com.sistemalanchonete.sistemalanchonete.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
@Table(name = "Estoque")
public class Estoque extends Entity {

    // Relacionamento com Compartimentos
    @JoinColumn(name = "ingrediente_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingrediente> ingredientes;

    @ManyToOne
    @JoinColumn(name = "código_compartimento", nullable = false)
    private Compartimento compartimento;

    @Column(name = "qtde_ingredientes", nullable = false)
    private Long qtdeIngredientes;

    // Regra de Negócio: Verificar disponibilidade com base nos ingredientes
    public boolean verificarDisponibilidade(Ingrediente ingrediente, int quantidade) {
        return ingredientes.contains(ingrediente) && ingrediente.getQuantidade() >= quantidade;
    }
     //teste
    // Regra de Negócio: Monitoramento de estoque em tempo real
    public void atualizarQuantidade(Ingrediente ingrediente, int quantidade) {
        if (ingredientes.contains(ingrediente) && ingrediente.getQuantidade() >= quantidade) {
            ingrediente.setQuantidade(ingrediente.getQuantidade() - quantidade);
        } else {
            throw new IllegalArgumentException("Ingrediente não disponível em quantidade suficiente no estoque.");
        }
    }

    public Estoque() {
        super();
        this.ingredientes = new ArrayList<>(); // Initialize the list
    }
    public Estoque(String compartimento, String qtdeIngredientes, Ingrediente ingrediente ) {
        super(compartimento,qtdeIngredientes);
        this.ingredientes = new ArrayList<>(List.of(ingrediente));
    }
    private String formatarIngredientes() {
        if (ingredientes != null && !ingredientes.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Ingrediente ingrediente : ingredientes) {
                sb.append(ingrediente.toString()).append("; ");
            }
            return sb.toString();
        }
        return "Sem Ingredientes";
    }
    public List<Ingrediente> getIngredientes() { return ingredientes;
    }

    // Correção aqui - utilize um método específico para setar os endereços
    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }


    // Construtor com campos
    public Estoque(Compartimento compartimento, Long qtdeIngredientes) {
        super();
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
