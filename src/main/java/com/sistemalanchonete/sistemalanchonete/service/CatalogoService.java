package com.sistemalanchonete.sistemalanchonete.service;

import com.sistemalanchonete.sistemalanchonete.model.Catalogo;
import com.sistemalanchonete.sistemalanchonete.model.Cliente;
import com.sistemalanchonete.sistemalanchonete.repository.CatalogoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogoService {

    @Autowired
    private CatalogoRepository repository;

    public Catalogo salvar( Catalogo entity){
        return repository.save(entity);
    }

    public List<Catalogo> buscaTodos(String filter) {
        return repository.findAll(filter, Catalogo.class);
    }

    public Page<Catalogo> buscaTodos(String filter, Pageable pageable) {
        return repository.findAll(filter, Catalogo.class, pageable);
    }
}
