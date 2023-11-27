package com.sistemalanchonete.sistemalanchonete.resource.representation;

import com.sistemalanchonete.sistemalanchonete.model.Endereco;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

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
    public static EnderecoDTO fromEntity(Endereco endereco) {
        EnderecoDTO dto = new EnderecoDTO();
        dto.setId(endereco.getId());
        dto.setRua(endereco.getRua());
        dto.setCep(endereco.getCep());
        dto.setCidade(endereco.getCidade());
        dto.setEstado(endereco.getEstado());
        dto.setComplemento(endereco.getComplemento());
        return dto;
    }

    public Endereco toEntity() {
        Endereco endereco = new Endereco();
        Endereco.setId(this.getId());
        Endereco.setRua(this.getRua());
        Endereco.setCep(this.getCep());
        Endereco.setCidade(this.getCidade());
        Endereco.setEstado(this.getEstado());
        Endereco.setComplemento(this.getComplemento());
        return endereco;
    }


    public static List<EnderecoDTO> fromEntity(List<Endereco> enderecos) {
        return enderecos.stream().map(endereco -> fromEntity(endereco)).collect(Collectors.toList());
    }

    public static Page<EnderecoDTO> fromEntity(Page<Endereco> enderecos) {
        List<EnderecoDTO> enderecosFind = enderecos.stream().map(endereco -> fromEntity(endereco)).collect(Collectors.toList());
        Page<EnderecoDTO> enderecoDTOS = new PageImpl<>(enderecosFind, enderecos.getPageable(), enderecos.getTotalElements());
        return enderecoDTOS;
    }


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

    public String getEstado() {
        return cliente;
    }

    public void setEstado(String estado) {this.cliente= estado;    }
}
