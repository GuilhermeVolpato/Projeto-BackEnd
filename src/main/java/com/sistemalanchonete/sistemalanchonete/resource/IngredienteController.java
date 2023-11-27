package com.sistemalanchonete.sistemalanchonete.resource;

import com.sistemalanchonete.sistemalanchonete.model.Cliente;
import com.sistemalanchonete.sistemalanchonete.model.Endereco;
import com.sistemalanchonete.sistemalanchonete.model.Estoque;
import com.sistemalanchonete.sistemalanchonete.model.Ingrediente;
import com.sistemalanchonete.sistemalanchonete.resource.representation.ClienteDTO;
import com.sistemalanchonete.sistemalanchonete.resource.representation.IngredienteDTO;
import com.sistemalanchonete.sistemalanchonete.service.ClienteService;
import com.sistemalanchonete.sistemalanchonete.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingrediente")
public class IngredienteController {

    @Autowired
    private IngredienteService service;
    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false) String filter,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size) {
        Page<Ingrediente> ingredientes =service.buscaTodos(filter, PageRequest.of(page, size));
        Page<IngredienteDTO> ingredienteDTOS = ingredientes.map(IngredienteDTO::fromEntity);
        return ResponseEntity.ok(ingredienteDTOS);
    }
    @PostMapping("/Cadastro")
    public ResponseEntity<Ingrediente> create(@RequestBody Ingrediente ingrediente) {
        // Certifique-se de que os endereços estão associados ao cliente
        List<Estoque> estoques = ingrediente.getEstoque();
        Ingrediente novoIngrediente = service.salvar(ingrediente);
        return new ResponseEntity<>(novoIngrediente, HttpStatus.CREATED);
    }
}
