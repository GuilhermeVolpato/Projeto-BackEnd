package com.sistemalanchonete.sistemalanchonete.model;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "Pedido")
public class Pedido extends Entity {

    @Column(name = "nome_cliente_local", nullable = false)
    private String nomeClienteLocal;

    @Column(name = "isPedidoWeb", nullable = false)
    private Boolean isPedidoWeb;

    @Column(name = "valor_total", nullable = false)
    private Double valorTotal;

    @Column(name = "valor_desconto", nullable = false)
    private Double valorDesconto;

    @Column(name = "valor_final", nullable = false)
    private Double valorFinal;

    @Column(name = "código_cupom", nullable = false)
    private String codigoCupom;

    @Column(name = "id_mesa", nullable = false)
    private Long idMesa;

    @Column(name = "metodo_pagto", nullable = false)
    private MetodoPagamento metodoPagamento;

    // Relacionamento com Cliente
    @ManyToOne
    @JoinColumn(name = "cliente", nullable = false)
    private Cliente cliente;

    // Relacionamento com Funcionario
    @ManyToOne
    @JoinColumn(name = "funcionario", nullable = false)
    private Funcionario funcionario;

    // Relacionamento com Item_pedido
    @ManyToOne
    @JoinColumn(name = "itens_carrinho", nullable = false)
    private ItemPedido itensCarrinho;
    @ManyToOne
    @JoinColumn(name = "endereco_id", nullable = false)
    private Endereco endereco;


    public Pedido() {
        super();
    }

    // Construtor com campos
    public Pedido(String nomeClienteLocal, Boolean isPedidoWeb, Double valorTotal, Double valorDesconto, Double valorFinal, String codigoCupom, Long idMesa, MetodoPagamento metodoPagamento, Cliente cliente, Funcionario funcionario, ItemPedido itensCarrinho, Endereco endereco) {
        super();
        this.nomeClienteLocal = nomeClienteLocal;
        this.isPedidoWeb = isPedidoWeb;
        this.valorTotal = valorTotal;
        this.valorDesconto = valorDesconto;
        this.valorFinal = valorFinal;
        this.codigoCupom = codigoCupom;
        this.idMesa = idMesa;
        this.metodoPagamento = metodoPagamento;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.itensCarrinho = itensCarrinho;
        this.endereco = endereco;
    }

    public String getNomeClienteLocal() {
        return nomeClienteLocal;
    }

    public void setNomeClienteLocal(String nomeClienteLocal) {
        this.nomeClienteLocal = nomeClienteLocal;
    }

    public Boolean getPedidoWeb() {
        return isPedidoWeb;
    }

    public void setPedidoWeb(Boolean pedidoWeb) {
        isPedidoWeb = pedidoWeb;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public String getCodigoCupom() {
        return codigoCupom;
    }

    public void setCodigoCupom(String codigoCupom) {
        this.codigoCupom = codigoCupom;
    }

    public Long getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Long idMesa) {
        this.idMesa = idMesa;
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public ItemPedido getItensCarrinho() {
        return itensCarrinho;
    }

    public void setItensCarrinho(ItemPedido itensCarrinho) {
        this.itensCarrinho = itensCarrinho;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
