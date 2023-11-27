package com.sistemalanchonete.sistemalanchonete.service;

import com.sistemalanchonete.sistemalanchonete.model.Cliente;
import com.sistemalanchonete.sistemalanchonete.model.Ingrediente;
import com.sistemalanchonete.sistemalanchonete.repository.ClienteRepository;
import com.sistemalanchonete.sistemalanchonete.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredienteService {
    @Autowired
    private IngredienteRepository repository;

    public Ingrediente salvar(Ingrediente entity){return repository.save(entity);    }

    public List<Ingrediente> buscaTodos(String filter) {
        return repository.findAll(filter, Ingrediente.class);
    }

    public Page<Ingrediente> buscaTodos(String filter, Pageable pageable) {
        return repository.findAll(filter, Ingrediente.class, pageable);
    }
}
