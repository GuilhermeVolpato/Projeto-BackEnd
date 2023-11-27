package com.sistemalanchonete.sistemalanchonete.resource;

import com.sistemalanchonete.sistemalanchonete.model.Cliente;
import com.sistemalanchonete.sistemalanchonete.model.Estoque;
import com.sistemalanchonete.sistemalanchonete.model.Ingrediente;
import com.sistemalanchonete.sistemalanchonete.resource.representation.ClienteDTO;
import com.sistemalanchonete.sistemalanchonete.resource.representation.EstoqueDTO;
import com.sistemalanchonete.sistemalanchonete.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueController extends AbstractController {

    @Autowired
    private EstoqueService service;
    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false) String filter,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size) {
        Page<Estoque> estoques = service.buscaTodos(filter, PageRequest.of(page, size));
        Page<EstoqueDTO> estoqueDTOS = estoques.map(EstoqueDTO::fromEntity);
        return ResponseEntity.ok(estoqueDTOS);
    }
    @PostMapping("/Cadastro")
    public ResponseEntity<Estoque> create(@RequestBody Estoque estoque) {
        // Certifique-se de que os endereços estão associados ao cliente
        String ingredientes = estoque.getIngredientes();
        Estoque novoEstoque = service.salvar(estoque);
        return new ResponseEntity<>(novoEstoque, HttpStatus.CREATED);
    }
}