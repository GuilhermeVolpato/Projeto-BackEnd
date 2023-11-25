package com.sistemalanchonete.sistemalanchonete.service;

import com.sistemalanchonete.sistemalanchonete.model.Estoque;
import com.sistemalanchonete.sistemalanchonete.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService {
    @Autowired
    private EstoqueRepository repository;

    public Estoque salvar(Estoque entity){
        return repository.save(entity);
    }
}
