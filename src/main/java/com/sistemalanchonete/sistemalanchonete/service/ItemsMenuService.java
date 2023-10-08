package com.sistemalanchonete.sistemalanchonete.service;

import com.sistemalanchonete.sistemalanchonete.model.ItemsMenu;
import com.sistemalanchonete.sistemalanchonete.model.QItemsMenu;
import com.sistemalanchonete.sistemalanchonete.repository.ItemsMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsMenuService {
    @Autowired
    private ItemsMenuRepository repository;

    public List<ItemsMenu> findAll() {
        List<ItemsMenu> alugados = repository.
                findAll(QItemsMenu.ItemMenu.status.in(Situacao, Situacao));
        return alugados;
    }
}
