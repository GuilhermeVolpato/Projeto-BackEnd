package com.sistemalanchonete.sistemalanchonete.resource;

import com.sistemalanchonete.sistemalanchonete.model.Cliente;
import com.sistemalanchonete.sistemalanchonete.model.Endereco;
import com.sistemalanchonete.sistemalanchonete.model.Funcionario;
import com.sistemalanchonete.sistemalanchonete.service.ClienteService;
import com.sistemalanchonete.sistemalanchonete.service.EnderecoService;
import com.sistemalanchonete.sistemalanchonete.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController extends AbstractController{

        @Autowired
        private EnderecoService service;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private FuncionarioService funcionarioService;



    @PostMapping("/adicionarEndereco/{idClienteOuFuncionario}")
    public ResponseEntity<Endereco> adicionarEndereco(
            @PathVariable Long idClienteOuFuncionario,
            @RequestBody Endereco novoEndereco) {

        // Verifica se o ID pertence a um cliente
        Cliente cliente = clienteService.buscarPorId(idClienteOuFuncionario);
        if (cliente != null) {
            adicionarEnderecoCliente(cliente, novoEndereco);
            return new ResponseEntity<>(novoEndereco, HttpStatus.CREATED);
        }

        // Verifica se o ID pertence a um funcionário
        Funcionario funcionario = funcionarioService.buscarPorId(idClienteOuFuncionario);
        if (funcionario != null) {
            adicionarEnderecoFuncionario(funcionario, novoEndereco);
            return new ResponseEntity<>(novoEndereco, HttpStatus.CREATED);
        }

        // Se o ID não corresponder a nenhum cliente ou funcionário, retorna Not Found
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    private void adicionarEnderecoCliente(Cliente cliente, Endereco novoEndereco) {
        novoEndereco.setId(null);
        novoEndereco.associarCliente(cliente);
        cliente.getEnderecos().add(novoEndereco);
        clienteService.salvar(cliente);
    }

    private void adicionarEnderecoFuncionario(Funcionario funcionario, Endereco novoEndereco) {
        novoEndereco.setId(null);
        novoEndereco.associarFuncionario(funcionario);
        funcionario.getEnderecos().add(novoEndereco);
        funcionarioService.salvar(funcionario);
    }
}
