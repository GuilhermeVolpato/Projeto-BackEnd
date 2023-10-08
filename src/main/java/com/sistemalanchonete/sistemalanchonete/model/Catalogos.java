package com.sistemalanchonete.sistemalanchonete.model;

import java.time.LocalDate;

public class Catalogos extends Entity{
    private ItemsMenu produto;
    private LocalDate validade;
    private String descricao;
    private String alergenicos;
    private Integer restricaoIdade;
    private Double desconto;
    private Double tempoPreparo;

    public ItemsMenu getProduto() {
        return produto;
    }

    public void setProduto(ItemsMenu produto) {
        this.produto = produto;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAlergenicos() {
        return alergenicos;
    }

    public void setAlergenicos(String alergenicos) {
        this.alergenicos = alergenicos;
    }

    public Integer getRestricaoIdade() {
        return restricaoIdade;
    }

    public void setRestricaoIdade(Integer restricaoIdade) {
        this.restricaoIdade = restricaoIdade;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(Double tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }
}
