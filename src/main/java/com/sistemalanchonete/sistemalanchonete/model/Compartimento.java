package com.sistemalanchonete.sistemalanchonete.model;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "Compartimentos")
public class Compartimento extends Entity {

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "tipo_armazenamento", nullable = false)
    private String tipoArmazenamento;

    public Compartimento() {
    }

    // Construtor com campos
    public Compartimento(String nome, String tipoArmazenamento) {
        this.nome = nome;
        this.tipoArmazenamento = tipoArmazenamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoArmazenamento() {
        return tipoArmazenamento;
    }

    public void setTipoArmazenamento(String tipoArmazenamento) {
        this.tipoArmazenamento = tipoArmazenamento;
    }
}
