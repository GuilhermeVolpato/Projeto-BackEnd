package com.sistemalanchonete.sistemalanchonete.model;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Cliente")
public class Cliente extends Usuario {

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> enderecos;


    public Cliente() {
        super();
        this.enderecos = new ArrayList<>(); // Initialize the list
    }

    public Cliente(String nome, String cpf, String telefone, String email, String senha, Date dtNascimento, Endereco endereco) {
        super(nome, cpf, telefone, email, senha, dtNascimento);
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

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
        for (Endereco endereco : enderecos) {
            endereco.associarCliente(this);
        }
    }


    @ElementCollection
    @CollectionTable(name = "Alergias", joinColumns = @JoinColumn(name = "cliente_id"))
    @Column(name = "alergia")
    private List<String> alergias;

    @ElementCollection
    @CollectionTable(name = "RestricoesAlimentares", joinColumns = @JoinColumn(name = "cliente_id"))
    @Column(name = "restricao_alimentar")
    private List<String> restricoesAlimentar;

    public List<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(List<String> alergias) {
        this.alergias = alergias;
    }

    public List<String> getRestricoesAlimentar() {
        return restricoesAlimentar;
    }

    public void setRestricoesAlimentar(List<String> restricoesAlimentar) {
        this.restricoesAlimentar = restricoesAlimentar;
    }
}

