package com.sistemalanchonete.sistemalanchonete.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido extends Entity{
    private LocalDate dataVenda;
    private LocalDate previsaoEntrega;
    private Cliente cliente;
    private Status status;
    private String observacaoCliente;
    private TipoPedido tipoPedido;
    private String cep;
    private String bairro;
    private String rua;
    private String complemento;
    private Mesa mesa;
    private Atendente atendente;

    private List<ItemPedido> itens = new ArrayList<>();

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public LocalDate getPrevisaoEntrega() {
        return previsaoEntrega;
    }

    public void setPrevisaoEntrega(LocalDate previsaoEntrega) {
        this.previsaoEntrega = previsaoEntrega;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        if (atendente.getSituacao() == Situacao.ATIVO) {
            this.atendente = atendente;
        } else {
            throw new RuntimeException("Atendente não está ativo");
        }
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getObservacaoCliente() {
        return observacaoCliente;
    }

    public void setObservacaoCliente(String observacaoCliente) {
        this.observacaoCliente = observacaoCliente;
    }

    public TipoPedido getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(TipoPedido tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public void addItemPedido(ItemPedido item) {
        item.setPedido(this);
        this.itens.add(item);
    }

    public void delItemPedido(ItemPedido item) {
        this.itens.remove(item);
    }


    public List<ItemPedido> getItens() {
        return itens;
    }
}

