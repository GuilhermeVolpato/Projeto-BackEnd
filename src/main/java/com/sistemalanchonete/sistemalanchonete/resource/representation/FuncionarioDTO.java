package com.sistemalanchonete.sistemalanchonete.resource.representation;

import com.sistemalanchonete.sistemalanchonete.model.Cliente;
import com.sistemalanchonete.sistemalanchonete.model.Funcionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

public class FuncionarioDTO {
    private Long id;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;

    public static FuncionarioDTO fromEntity(Funcionario funcionario) {
        FuncionarioDTO dto = new FuncionarioDTO();
        dto.setId(funcionario.getId());
        dto.setNome(funcionario.getNome());
        dto.setTelefone(funcionario.getTelefone());
        dto.setEmail(funcionario.getEmail());
        return dto;
    }

    public Funcionario toEntity() {
        Funcionario Funcionario = new Funcionario();
        Funcionario.setId(this.getId());
        Funcionario.setNome(this.getNome());
        Funcionario.setTelefone(this.getTelefone());
        Funcionario.setEmail(this.getEmail());
        return Funcionario;
    }

    public static List<FuncionarioDTO> fromEntity(List<Funcionario> funcionarios) {
        return funcionarios.stream().map(funcionario -> fromEntity(funcionario)).collect(Collectors.toList());
    }

    public static Page<FuncionarioDTO> fromEntity(Page<Funcionario> funcionarios) {
        List<FuncionarioDTO> funcionariosFind = funcionarios.stream().map(funcionario -> fromEntity(funcionario)).collect(Collectors.toList());
        Page<FuncionarioDTO> funcionarioDTOS = new PageImpl<>(funcionariosFind, funcionarios.getPageable(), funcionarios.getTotalElements());
        return funcionarioDTOS;
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
