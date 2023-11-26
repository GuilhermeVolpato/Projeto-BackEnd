package com.sistemalanchonete.sistemalanchonete.service;

import com.sistemalanchonete.sistemalanchonete.model.Cliente;
import com.sistemalanchonete.sistemalanchonete.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente salvar( Cliente entity){
        return repository.save(entity);
    }

    public List<Cliente> buscaTodos(String filter) {
        return repository.findAll(filter, Cliente.class);
    }

    public Page<Cliente> buscaTodos(String filter, Pageable pageable) {
        return repository.findAll(filter, Cliente.class, pageable);
    }


    public Cliente buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

}
