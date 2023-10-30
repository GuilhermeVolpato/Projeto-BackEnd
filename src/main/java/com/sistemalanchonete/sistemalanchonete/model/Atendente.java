package com.sistemalanchonete.sistemalanchonete.model;

public class Atendente extends Usuario{
    private Situacao situacao;

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

}
