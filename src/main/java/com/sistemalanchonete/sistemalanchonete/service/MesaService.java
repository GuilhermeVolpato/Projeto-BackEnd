package com.sistemalanchonete.sistemalanchonete.service;

import com.sistemalanchonete.sistemalanchonete.model.Cliente;
import com.sistemalanchonete.sistemalanchonete.model.Mesa;
import com.sistemalanchonete.sistemalanchonete.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesaService {

    @Autowired
    private MesaRepository repository;

    public Mesa buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

}
