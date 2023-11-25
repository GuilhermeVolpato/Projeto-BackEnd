package com.sistemalanchonete.sistemalanchonete.resource.representation;

public class EstoqueDTO {
    private Long id;
    private String compartimento;
    private String qtdeIngredientes;
    private String ingrediente;

    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompartimento() {
        return compartimento;
    }

    public void setCompartimento(String compartimento) {
        this.compartimento = compartimento;
    }

    public String getQtdeIngredientes() {
        return qtdeIngredientes;
    }

    public void setQtdeIngredientes(String qtdeIngredientes) {this.qtdeIngredientes = qtdeIngredientes; }

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }
}
