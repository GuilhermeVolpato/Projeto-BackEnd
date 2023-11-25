package com.sistemalanchonete.sistemalanchonete.resource;

import com.sistemalanchonete.sistemalanchonete.model.Catalogo;
import com.sistemalanchonete.sistemalanchonete.model.Ingrediente;
import com.sistemalanchonete.sistemalanchonete.model.ItensVenda;
import com.sistemalanchonete.sistemalanchonete.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/api/catalogo")
public class CatalogoController extends AbstractController{


    @Autowired
        private CatalogoService service;
        @PostMapping("/Cadastro")
        public ResponseEntity<Catalogo> create(@RequestBody Catalogo catalogo) {
            // Certifique-se de que os endereços estão associados ao cliente
            List<ItensVenda> itensVendas = catalogo.getItensVendas();
            Catalogo novoCatalogo = service.salvar(catalogo);
            return new ResponseEntity<>(novoCatalogo, HttpStatus.CREATED);
        }
    }
