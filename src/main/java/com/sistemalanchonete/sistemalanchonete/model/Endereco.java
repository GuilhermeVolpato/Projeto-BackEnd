package com.sistemalanchonete.sistemalanchonete.model;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "Endereco")
public class Endereco extends Entity {

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

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

    public Endereco() {
        super();
    }

    public Endereco(String rua, String cep, String cidade, String estado, String bairro, Long numero, String complemento) {
        super();
        this.rua = rua;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public void associarCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void associarFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }


    public String getRua() {
        return rua;
    }

    public static void setRua(String rua) {   }

    public String getCep() {
        return cep;
    }

    public static void setCep(String cep) {
    }

    public String getCidade() {
        return cidade;
    }

    public static void setCidade(String cidade) {

    }

    public String getEstado() {
        return estado;
    }

    public static void setEstado(String estado) {
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

    public static void setNumero(Long numero) {
    }

    public String getComplemento() {
        return complemento;
    }

    public static void setComplemento(String complemento) {
    }

}
