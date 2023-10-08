package com.sistemalanchonete.sistemalanchonete.model;

import java.util.ArrayList;
import java.util.List;

public class Menu extends Entity{
    private String descricao;
    private Situacao situacao;
    private List<ItemsMenu> itens = new ArrayList<>();

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
}
