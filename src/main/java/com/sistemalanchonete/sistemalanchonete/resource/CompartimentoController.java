package com.sistemalanchonete.sistemalanchonete.resource;

import com.sistemalanchonete.sistemalanchonete.model.Compartimento;
import com.sistemalanchonete.sistemalanchonete.model.Estoque;
import com.sistemalanchonete.sistemalanchonete.model.Ingrediente;
import com.sistemalanchonete.sistemalanchonete.service.CompartimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/compartimento")
public class CompartimentoController {

    @Autowired
    private CompartimentoService service;

    @PostMapping("/Cadastro")
    public ResponseEntity<Compartimento> create(@RequestBody Compartimento compartimento) {
        Compartimento novoCompartimento = service.salvar(compartimento);
        return new ResponseEntity<>(novoCompartimento, HttpStatus.CREATED);
    }
}
