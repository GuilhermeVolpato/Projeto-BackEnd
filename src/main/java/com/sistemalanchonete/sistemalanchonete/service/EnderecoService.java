package com.sistemalanchonete.sistemalanchonete.service;

import com.sistemalanchonete.sistemalanchonete.model.Cliente;
import com.sistemalanchonete.sistemalanchonete.model.Endereco;
import com.sistemalanchonete.sistemalanchonete.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

        @Autowired
        private EnderecoRepository repository;

        public Endereco salvar(Endereco entity){
            return repository.save(entity);
        }

    public List<Endereco> buscaTodos(String filter) {
        return repository.findAll(filter, Endereco.class);
    }

    public Page<Endereco> buscaTodos(String filter, Pageable pageable) {
        return repository.findAll(filter, Endereco.class, pageable);
    }
    }