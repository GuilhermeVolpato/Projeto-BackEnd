package com.sistemalanchonete.sistemalanchonete.model;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Funcionario")
public class Funcionario extends Usuario {

    @JoinColumn(name = "endereco_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> enderecos;

    @Column(name = "nome_cargo", nullable = false)
    private String nomeCargo;

    @Column(name = "nivel_acesso", nullable = false)
    private Integer nivelAcesso;

    // Construtores, getters e setters

    // Exemplo de construtor vazio para JPA
    public Funcionario() {
        super();
        this.enderecos = new ArrayList<>(); // Initialize the list
    }

    public Funcionario(String nomeCargo, Integer nivelAcesso, Endereco endereco) {
            super(nomeCargo, nivelAcesso);
            this.enderecos = new ArrayList<>(List.of(endereco));
    }
    private String formatarEnderecos() {
        if (enderecos != null && !enderecos.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Endereco endereco : enderecos) {
                sb.append(endereco.toString()).append("; ");
            }
            return sb.toString();
        }
        return "Sem endereços";
    }

    public List<Endereco> getEnderecos() { return enderecos;
    }

    // Correção aqui - utilize um método específico para setar os endereços
    public void setEnderecos(List<Endereco> enderecos) {this.enderecos = enderecos;}

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
