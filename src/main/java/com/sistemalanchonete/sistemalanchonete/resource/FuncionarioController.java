package com.sistemalanchonete.sistemalanchonete.resource;

import com.sistemalanchonete.sistemalanchonete.model.Cliente;
import com.sistemalanchonete.sistemalanchonete.model.Endereco;
import com.sistemalanchonete.sistemalanchonete.model.Funcionario;
import com.sistemalanchonete.sistemalanchonete.resource.representation.ClienteDTO;
import com.sistemalanchonete.sistemalanchonete.resource.representation.FuncionarioDTO;
import com.sistemalanchonete.sistemalanchonete.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/funcionario")

public class FuncionarioController extends AbstractController {

        @Autowired
        private FuncionarioService funcionarioService;
    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false) String filter,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size) {
        Page<Funcionario> funcionarios = funcionarioService.buscaTodos(filter, PageRequest.of(page, size));
        Page<FuncionarioDTO> funcionarioDTOS = funcionarios.map(FuncionarioDTO::fromEntity);
        return ResponseEntity.ok(funcionarios);
    }

        @PostMapping("/Cadastro")
        public ResponseEntity<Funcionario> create(@RequestBody Funcionario funcionario) {
            List<Endereco> enderecos = funcionario.getEnderecos();

            if (enderecos == null || enderecos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            Funcionario novoFuncionario = funcionarioService.salvar(funcionario);

            for (Endereco endereco : enderecos) {
                endereco.associarFuncionario(novoFuncionario);
            }

            return new ResponseEntity<>(novoFuncionario, HttpStatus.CREATED);
        }
}
