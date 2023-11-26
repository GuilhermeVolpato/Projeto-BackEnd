package com.sistemalanchonete.sistemalanchonete.resource;

import com.sistemalanchonete.sistemalanchonete.model.Estoque;
import com.sistemalanchonete.sistemalanchonete.model.Ingrediente;
import com.sistemalanchonete.sistemalanchonete.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueController extends AbstractController {

    @Autowired
    private EstoqueService service;
    @PostMapping("/Cadastro")
    public ResponseEntity<Estoque> create(@RequestBody Estoque estoque) {
        // Certifique-se de que os endereços estão associados ao cliente
        List<Ingrediente> ingredientes = estoque.getIngredientes();
        Estoque novoEstoque = service.salvar(estoque);
        return new ResponseEntity<>(novoEstoque, HttpStatus.CREATED);
    }
}