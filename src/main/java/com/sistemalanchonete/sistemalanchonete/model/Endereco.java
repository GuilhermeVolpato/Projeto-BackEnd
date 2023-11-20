package com.sistemalanchonete.sistemalanchonete.model;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "Endereco")
public class Endereco extends Entity {

    @Column(name = "rua", nullable = false)
    private String rua;

    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "cidade", nullable = false)
    private String cidade;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "bairro", nullable = false)
    private String bairro;

    @Column(name = "numero", nullable = false)
    private Long numero;

    @Column(name = "complemento", nullable = false)
    private String complemento;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    // Construtores, getters e setters

    // Exemplo de construtor vazio para JPA
    public Endereco() {
    }

    // Construtor com campos
    public Endereco(String rua, String cep, String cidade, String estado, String bairro, Long numero, String complemento, Cliente cliente) {
        this.rua = rua;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.cliente = cliente;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
