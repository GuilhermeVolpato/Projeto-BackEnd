package com.sistemalanchonete.sistemalanchonete.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class Usuario extends Entity{
    private String nome;
    private String telefone;
    private String email;
    private Date dataNascimento;
    @Column(name = "cpf", nullable = false)
    private String cpf;
    @Column(name = "rg", nullable = true)
    private String rg;

    public Usuario(String nome, String cpf, String telefone, String email, String senha) {
        super();
    }

    public Usuario() {
        super();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }



}
