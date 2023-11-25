package com.sistemalanchonete.sistemalanchonete.service;

import com.sistemalanchonete.sistemalanchonete.model.Catalogo;
import com.sistemalanchonete.sistemalanchonete.repository.CatalogoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogoService {

    @Autowired
    private CatalogoRepository repository;

    public Catalogo salvar( Catalogo entity){
        return repository.save(entity);
    }
}
