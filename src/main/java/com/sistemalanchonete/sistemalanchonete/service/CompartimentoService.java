package com.sistemalanchonete.sistemalanchonete.service;

import com.sistemalanchonete.sistemalanchonete.model.Compartimento;
import com.sistemalanchonete.sistemalanchonete.repository.CompartimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompartimentoService {

    @Autowired
    private CompartimentoRepository repository;

    public Compartimento salvar(Compartimento entity){
        return repository.save(entity);
    }
}
