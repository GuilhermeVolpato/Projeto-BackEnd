package com.sistemalanchonete.sistemalanchonete.service;

import com.sistemalanchonete.sistemalanchonete.model.Cliente;
import com.sistemalanchonete.sistemalanchonete.model.ItemPedido;
import com.sistemalanchonete.sistemalanchonete.repository.ClienteRepository;
import com.sistemalanchonete.sistemalanchonete.repository.ItensPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItensPedidoService {
    @Autowired
    private ItensPedidoRepository repository;

    public ItemPedido salvar(ItemPedido entity){
        return repository.save(entity);
    }
}
