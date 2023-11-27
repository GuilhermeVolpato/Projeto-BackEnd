package com.sistemalanchonete.sistemalanchonete.service;

import com.sistemalanchonete.sistemalanchonete.model.Cliente;
import com.sistemalanchonete.sistemalanchonete.model.ItensVenda;
import com.sistemalanchonete.sistemalanchonete.repository.ClienteRepository;
import com.sistemalanchonete.sistemalanchonete.repository.ItensVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItensVendaService {
    @Autowired
    private ItensVendaRepository repository;

    public ItensVenda salvar(ItensVenda entity){return repository.save(entity); }

}
