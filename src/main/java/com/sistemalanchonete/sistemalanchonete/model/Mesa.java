package com.sistemalanchonete.sistemalanchonete.model;

// id = numero da mesa
// idpedido

public class Mesa extends Entity {
    private Integer quantidadePessoas;
    private Situacao situacao;

    public Integer getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(Integer quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
}
