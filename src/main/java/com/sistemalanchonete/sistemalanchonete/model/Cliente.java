package com.sistemalanchonete.sistemalanchonete.model;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Cliente")
public class Cliente extends Usuario {

    @JoinColumn(name = "endereco_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> enderecos;

    public Cliente() {
        super();
        this.enderecos = new ArrayList<>(); // Initialize the list
    }

    public Cliente(String nome, String cpf, String telefone, String email, String senha, Endereco endereco, Date dtNascimento) {
        super(nome, cpf, telefone, email, senha);
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

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    // Correção aqui - utilize um método específico para setar os endereços
    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}

