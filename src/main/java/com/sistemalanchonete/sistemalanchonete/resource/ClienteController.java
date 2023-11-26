package com.sistemalanchonete.sistemalanchonete.resource;

import com.sistemalanchonete.sistemalanchonete.model.Cliente;
import com.sistemalanchonete.sistemalanchonete.model.Endereco;
import com.sistemalanchonete.sistemalanchonete.resource.representation.ClienteDTO;
import com.sistemalanchonete.sistemalanchonete.service.ClienteService;
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
@RequestMapping("/api/clientes")
public class ClienteController extends AbstractController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false) String filter,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size) {
        List<Cliente> clientes = clienteService.buscaTodos(filter, PageRequest.of(page, size));
        List<ClienteDTO> clienteDTOS = ClienteDTO.fromEntity(clientes);
        return ResponseEntity.ok(clienteDTOS);
    }

    @PostMapping("/Cadastro")
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        List<Endereco> enderecos = cliente.getEnderecos();

        if (enderecos == null || enderecos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Cliente novoCliente = clienteService.salvar(cliente);

        for (Endereco endereco : enderecos) {
            endereco.associarCliente(novoCliente);
        }

        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }
}