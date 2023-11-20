package com.sistemalanchonete.sistemalanchonete.model;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Cliente")
public class Cliente extends Usuario {

    // Relacionamento com Endereco
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

    @Column(name = "dt_nascimento", nullable = false)
    private Date dtNascimento;

    public Cliente() {
        super();
        this.enderecos = new ArrayList<>(); // Initialize the list
    }

    public Cliente(String nome, String cpf, String telefone, String email, String senha, Endereco endereco, Date dtNascimento) {
        super(nome, cpf, telefone, email, senha);
        this.enderecos = new ArrayList<>(List.of(endereco));
        endereco.setCliente(this); // Configurar a propriedade cliente no endereço
        this.dtNascimento = dtNascimento;
    }

    @Override
    public String getEndereco() {

        return this.enderecos.toString();
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

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }
}

