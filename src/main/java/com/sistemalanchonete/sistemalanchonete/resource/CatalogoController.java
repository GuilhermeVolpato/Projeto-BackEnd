package com.sistemalanchonete.sistemalanchonete.resource;

import com.sistemalanchonete.sistemalanchonete.model.Catalogo;
import com.sistemalanchonete.sistemalanchonete.model.Cliente;
import com.sistemalanchonete.sistemalanchonete.model.Ingrediente;
import com.sistemalanchonete.sistemalanchonete.model.ItensVenda;
import com.sistemalanchonete.sistemalanchonete.resource.representation.CatalogoDTO;
import com.sistemalanchonete.sistemalanchonete.resource.representation.ClienteDTO;
import com.sistemalanchonete.sistemalanchonete.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false) String filter,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size) {
        Page<Catalogo> catalogos = service.buscaTodos(filter, PageRequest.of(page, size));
        Page<CatalogoDTO> catalogoDTOS = catalogos.map(CatalogoDTO::fromEntity);
        return ResponseEntity.ok(catalogoDTOS);
    }
        @PostMapping("/Cadastro")
        public ResponseEntity<Catalogo> create(@RequestBody Catalogo catalogo) {
            // Certifique-se de que os endereços estão associados ao cliente
            List<ItensVenda> itensVendas = catalogo.getItensVendas();
            Catalogo novoCatalogo = service.salvar(catalogo);
            return new ResponseEntity<>(novoCatalogo, HttpStatus.CREATED);
        }
    }
