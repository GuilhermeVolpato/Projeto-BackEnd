package com.sistemalanchonete.sistemalanchonete.resource;

import com.sistemalanchonete.sistemalanchonete.model.Cliente;
import com.sistemalanchonete.sistemalanchonete.model.Endereco;
import com.sistemalanchonete.sistemalanchonete.model.Estoque;
import com.sistemalanchonete.sistemalanchonete.model.Ingrediente;
import com.sistemalanchonete.sistemalanchonete.service.ClienteService;
import com.sistemalanchonete.sistemalanchonete.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ingrediente")
public class IngredienteController {

    @Autowired
    private IngredienteService service;
    @PostMapping("/Cadastro")
    public ResponseEntity<Ingrediente> create(@RequestBody Ingrediente ingrediente) {
        // Certifique-se de que os endereços estão associados ao cliente
        List<Estoque> estoques = ingrediente.getEstoque();
        Ingrediente novoIngrediente = service.salvar(ingrediente);
        return new ResponseEntity<>(novoIngrediente, HttpStatus.CREATED);
    }
}
