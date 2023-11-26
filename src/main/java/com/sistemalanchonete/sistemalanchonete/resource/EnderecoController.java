package com.sistemalanchonete.sistemalanchonete.resource;

import com.sistemalanchonete.sistemalanchonete.model.Cliente;
import com.sistemalanchonete.sistemalanchonete.model.Endereco;
import com.sistemalanchonete.sistemalanchonete.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController extends AbstractController{

        @Autowired
        private EnderecoService service;


        @PostMapping("/Cadastro")
        public ResponseEntity<Endereco> create(@RequestBody Endereco endereco) {
            // Certifique-se de que os endereços estão associados ao cliente
            List<Cliente> clientes = endereco.getClientes();
            Endereco novoEndereco = service.salvar(endereco);
            return new ResponseEntity<>(novoEndereco, HttpStatus.CREATED);
        }
    }
