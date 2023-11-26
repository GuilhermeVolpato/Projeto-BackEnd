package com.sistemalanchonete.sistemalanchonete.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
@Table(name = "Endereco")
public class Endereco extends Entity {
    @JoinColumn(name = "cliente_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cliente> clientes;
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

    // Construtores, getters e setters

    // Exemplo de construtor vazio para JPA
    public Endereco() {
        super();
        this.clientes = new ArrayList<>(); // Initialize the list
    }
    public Endereco(String rua, String cep, String cidade, String estado, String bairro, String numero, String complemento, Cliente cliente) {
        super(rua,cep);
        this.clientes = new ArrayList<>(List.of(cliente));
    }

    // Construtor com campos

    private String formatarCliente() {
        if (clientes != null && !clientes.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Cliente cliente : clientes) {
                sb.append(cliente.toString()).append("; ");
            }
            return sb.toString();
        }
        return "Sem clientes";
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    // Correção aqui - utilize um método específico para setar os endereços
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
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

}
