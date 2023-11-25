package com.sistemalanchonete.sistemalanchonete.resource;

import com.sistemalanchonete.sistemalanchonete.model.Cliente;
import com.sistemalanchonete.sistemalanchonete.model.Endereco;
import com.sistemalanchonete.sistemalanchonete.model.ItemPedido;
import com.sistemalanchonete.sistemalanchonete.model.ItensVenda;
import com.sistemalanchonete.sistemalanchonete.service.ClienteService;
import com.sistemalanchonete.sistemalanchonete.service.ItensVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/itensvenda")
public class ItensVendaController extends AbstractController{
        @Autowired
        private ItensVendaService service;
        @PostMapping("/Cadastro")
        public ResponseEntity<ItensVenda> create(@RequestBody ItensVenda itensVenda) {
            // Certifique-se de que os endereços estão associados ao cliente
            List<ItemPedido> itemPedidos = itensVenda.getItemPedidos();
            ItensVenda novoItensVenda = service.salvar(itensVenda);
            return new ResponseEntity<>(novoItensVenda, HttpStatus.CREATED);
        }
}
