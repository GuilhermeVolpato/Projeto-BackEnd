package com.sistemalanchonete.sistemalanchonete.service;

import com.sistemalanchonete.sistemalanchonete.repository.ItensVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemsMenuService {
    @Autowired
    private ItensVendaRepository repository;
}
