package com.sistemalanchonete.sistemalanchonete.service;

import com.sistemalanchonete.sistemalanchonete.model.Endereco;
import com.sistemalanchonete.sistemalanchonete.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EnderecoService {

        @Autowired
        private EnderecoRepository repository;

        public Endereco salvar(Endereco entity){
            return repository.save(entity);
        }
    }