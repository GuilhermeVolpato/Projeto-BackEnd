package com.sistemalanchonete.sistemalanchonete.resource.representation;

public class EnderecoDTO {
    private Long id;
    private String rua;
    private String cep;
    private String cidade;
    private String estado;
    private String bairro;
    private String numero;
    private String complemento;
    private String cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {return rua;}

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {this.cep = cep; }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {this.cidade = cidade; }

    public String getBairro() {return bairro;}

    public void setEmail(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {return complemento;}

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {this.numero = numero; }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {this.cliente= cliente;    }
}
