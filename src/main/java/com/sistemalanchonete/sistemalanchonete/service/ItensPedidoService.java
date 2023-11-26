package com.sistemalanchonete.sistemalanchonete.service;

import com.sistemalanchonete.sistemalanchonete.model.ItemPedido;
import com.sistemalanchonete.sistemalanchonete.repository.ItensPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItensPedidoService {
    @Autowired
    private ItensPedidoRepository repository;

    public List<ItemPedido> salvar(List<ItemPedido> entity){
        return repository.saveAll(entity);
    }
}
