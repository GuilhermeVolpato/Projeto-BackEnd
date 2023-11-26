package com.sistemalanchonete.sistemalanchonete.resource;

import com.sistemalanchonete.sistemalanchonete.model.Cliente;
import com.sistemalanchonete.sistemalanchonete.model.Endereco;
import com.sistemalanchonete.sistemalanchonete.model.Funcionario;
import com.sistemalanchonete.sistemalanchonete.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/funcionario")

public class FuncionarioController extends AbstractController {

        @Autowired
        private FuncionarioService funcionarioService;

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
