package com.sistemalanchonete.sistemalanchonete.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "metodo_pagto", nullable = false)
    private MetodoPagamento metodoPagamento;

    @Column(name = "tipo_entega")
    private Entrega tipoEntrega;

    // Relacionamento com Cliente
    @ManyToOne
    @JoinColumn(name = "cliente", nullable = false)
    private Cliente cliente;

    // Relacionamento com Funcionario
    @ManyToOne
    @JoinColumn(name = "funcionario", nullable = true)
    private Funcionario funcionario;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> itensCarrinho;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "mesa", nullable = true)
    private Mesa mesa;


    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Pedido() {
        super();
        this.itensCarrinho = new ArrayList<>();
    }

    // Construtor com campos
    public Pedido(String nomeClienteLocal, Boolean isPedidoWeb, Double valorTotal, Double valorDesconto, Double valorFinal, String codigoCupom, MetodoPagamento metodoPagamento, Cliente cliente, Funcionario funcionario, Endereco endereco) {
        super();
        this.nomeClienteLocal = nomeClienteLocal;
        this.isPedidoWeb = isPedidoWeb;
        this.valorTotal = valorTotal;
        this.valorDesconto = valorDesconto;
        this.valorFinal = valorFinal;
        this.codigoCupom = codigoCupom;
        this.metodoPagamento = metodoPagamento;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.endereco = endereco;

        this.itensCarrinho = new ArrayList<>();
    }

    // Regra de Negócio: Verificação de Idade para Bebidas
//    public void adicionarItem(ItemPedido item) {
//        if (item.getProduto().isBebidaAlcoolica() && cliente.getIdade() < 18) {
//            throw new IllegalArgumentException("O cliente não possui idade suficiente para comprar bebidas alcoólicas.");
//        }
//    }

    // Regra de Negócio: Calcular Frete Acima de 80 Reais
//    private double total;
//
//    public double calcularTotalComFrete() {
//        if (total > 80) {
//            return total;
//        } else {
//            return total + calcularFrete();
//        }
//    }
//
//    private double calcularFrete() {
//        // Lógica para calcular o valor do frete
//    }
//
//    // Regra de Negócio: Escolher o Tipo de Entrega
//
//    // Regra de Negócio: Alergias
//    private Cliente cliente;
//    private List<String> alergias;
//
//    public void adicionarAlergia(String alergia) {
//        alergias.add(alergia);
//    }
//


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

    public List<ItemPedido> getItensCarrinho() {
        return itensCarrinho;
    }

    public void setItensCarrinho(List<ItemPedido> itensCarrinho) {
        this.itensCarrinho = itensCarrinho;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Entrega getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(Entrega tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }
}
