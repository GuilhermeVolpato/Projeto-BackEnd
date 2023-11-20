package com.sistemalanchonete.sistemalanchonete.model;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "Funcionario")
public class Funcionario extends Usuario {

    @Column(name = "nome_cargo", nullable = false)
    private String nomeCargo;

    @Column(name = "nivel_acesso", nullable = false)
    private Integer nivelAcesso;

    // Construtores, getters e setters

    // Exemplo de construtor vazio para JPA
    public Funcionario() {
    }

    public Funcionario(String nomeCargo, Integer nivelAcesso) {
        this.nomeCargo = nomeCargo;
        this.nivelAcesso = nivelAcesso;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public Integer getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(Integer nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }


}
