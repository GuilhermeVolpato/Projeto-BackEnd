package com.sistemalanchonete.sistemalanchonete.service;

import com.sistemalanchonete.sistemalanchonete.model.Funcionario;
import com.sistemalanchonete.sistemalanchonete.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;

    public Funcionario salvar(Funcionario entity){return repository.save(entity);
    }
}
