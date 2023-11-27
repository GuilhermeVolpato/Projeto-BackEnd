package com.sistemalanchonete.sistemalanchonete.service;

import com.sistemalanchonete.sistemalanchonete.model.Cliente;
import com.sistemalanchonete.sistemalanchonete.model.Estoque;
import com.sistemalanchonete.sistemalanchonete.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueService {
    @Autowired
    private EstoqueRepository repository;

    public Estoque salvar(Estoque entity){
        return repository.save(entity);
    }

    public List<Estoque> buscaTodos(String filter) {
        return repository.findAll(filter, Estoque.class);
    }

    public Page<Estoque> buscaTodos(String filter, Pageable pageable) {
        return repository.findAll(filter, Estoque.class, pageable);
    }
}
