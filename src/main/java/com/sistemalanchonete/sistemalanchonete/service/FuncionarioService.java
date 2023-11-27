package com.sistemalanchonete.sistemalanchonete.service;

import com.sistemalanchonete.sistemalanchonete.model.Cliente;
import com.sistemalanchonete.sistemalanchonete.model.Funcionario;
import com.sistemalanchonete.sistemalanchonete.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;

    public Funcionario salvar(Funcionario entity){return repository.save(entity);
    }

    public List<Funcionario> buscaTodos(String filter) {
        return repository.findAll(filter, Funcionario.class);
    }

    public Page<Funcionario> buscaTodos(String filter, Pageable pageable) {
        return repository.findAll(filter, Funcionario.class, pageable);
    }
    public Funcionario buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}
