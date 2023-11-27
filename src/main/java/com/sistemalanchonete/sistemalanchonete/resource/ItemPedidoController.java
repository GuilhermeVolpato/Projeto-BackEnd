package com.sistemalanchonete.sistemalanchonete.resource;

import com.sistemalanchonete.sistemalanchonete.model.ItemPedido;
import com.sistemalanchonete.sistemalanchonete.model.ItensVenda;
import com.sistemalanchonete.sistemalanchonete.resource.AbstractController;
import com.sistemalanchonete.sistemalanchonete.service.ItensPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
    @RequestMapping("/api/itensPedido")
    public class ItemPedidoController extends AbstractController {
        @Autowired
        private ItensPedidoService service;
        @PostMapping("/Cadastro")
        public ResponseEntity<ItemPedido> create(@RequestBody ItemPedido itemPedido) {
            // Certifique-se de que os endereços estão associados ao cliente
            List<ItensVenda> itensVendas = itemPedido.getItensvendas();
            ItemPedido novoItemPedido = (ItemPedido) service.salvar((List<ItemPedido>) itemPedido);
            return new ResponseEntity<>(novoItemPedido, HttpStatus.CREATED);
        }
    }


