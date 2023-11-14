package com.sistemalanchonete.sistemalanchonete.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Entity
public class Cliente extends Usuario{
    @Column(name = "cpf", nullable = false)
    private String cpf;
    @Column(name = "rg", nullable = true)
    private String rg;
    @Column(name = "cep", nullable = false)
    private String cep;
    @Column(name="dt_nascimento", nullable = false)
    private Date dt_nascimento;

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public boolean isMaiorIdade(){
        Date data_atual = new Date();

        long idade = ChronoUnit.YEARS.between(dt_nascimento.toInstant(), data_atual.toInstant());

        return (idade >= 18 );
    }
}
