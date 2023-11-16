package com.sistemalanchonete.sistemalanchonete.model;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Table(name = "Cliente")
public class Cliente extends Usuario {

    // Relacionamento com Endereco
    @ManyToOne
    @JoinColumn(name = "endereço", nullable = false)
    private Endereco endereco;

    @Column(name = "dt_nascimento", nullable = false)
    private Date dtNascimento;

    public Cliente() {
        super();
    }

    // Construtor com campos
    public Cliente(String nome, String cpf, String telefone, String email, String senha, Endereco endereco, Date dtNascimento) {
        super(nome, cpf, telefone, email, senha);
        this.endereco = endereco;
        this.dtNascimento = dtNascimento;
    }

    @Override
    public String getEndereco() {
        return endereco.toString();
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }
}
