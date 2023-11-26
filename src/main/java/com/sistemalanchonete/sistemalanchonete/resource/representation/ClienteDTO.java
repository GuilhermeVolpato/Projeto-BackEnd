package com.sistemalanchonete.sistemalanchonete.resource.representation;

import com.sistemalanchonete.sistemalanchonete.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteDTO {
    private Long id;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;


    public static ClienteDTO fromEntity(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setTelefone(cliente.getTelefone());
        dto.setEmail(cliente.getEmail());
        return dto;
    }

    public Cliente toEntity() {
        Cliente Cliente = new Cliente();
        Cliente.setId(this.getId());
        Cliente.setNome(this.getNome());
        Cliente.setTelefone(this.getTelefone());
        Cliente.setEmail(this.getEmail());
        return Cliente;
    }

    public static List<ClienteDTO> fromEntity(List<Cliente> clientes) {
        return clientes.stream().map(cliente -> fromEntity(cliente)).collect(Collectors.toList());
    }

    public static Page<ClienteDTO> fromEntity(Page<Cliente> clientes) {
        List<ClienteDTO> clientesFind = clientes.stream().map(cliente -> fromEntity(cliente)).collect(Collectors.toList());
        Page<ClienteDTO> clienteDTOS = new PageImpl<>(clientesFind, clientes.getPageable(), clientes.getTotalElements());
        return clienteDTOS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
