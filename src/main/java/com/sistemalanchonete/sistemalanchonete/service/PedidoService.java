//Registro de Pedidos:
//
//        Somente os funcionários autorizados têm permissão para registrar pedidos no sistema.
//        Cada pedido deve incluir informações detalhadas, como itens selecionados, quantidade, mesa ou cliente associado e a hora do pedido.
//        Controle de Estoque:

package com.sistemalanchonete.sistemalanchonete.service;

import com.sistemalanchonete.sistemalanchonete.model.Cliente;
import com.sistemalanchonete.sistemalanchonete.model.Funcionario;
import com.sistemalanchonete.sistemalanchonete.model.Pedido;
import com.sistemalanchonete.sistemalanchonete.repository.AtendenteRepository;
import com.sistemalanchonete.sistemalanchonete.repository.ClienteRepository;
import com.sistemalanchonete.sistemalanchonete.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private AtendenteRepository atendenteRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    public Pedido salvar(Pedido pedido) {

        if (pedido.getFuncionario() != null && pedido.getFuncionario().getId() != null &&
                pedido.getCliente() != null && pedido.getCliente().getId() != null) {
            Funcionario funcionario = atendenteRepository.findById(pedido.getFuncionario().getId()).orElse(null);
            if (funcionario != null ) {
                return repository.save(pedido);
            } else {
                throw new RuntimeException("Atendente não está ativo ou é inválido");
            }
        } else {
            throw new RuntimeException("ID de Atendente e/ou Cliente inválido(s)");
        }
    }

    public void verificarRestricoesCliente(Cliente cliente) {
        List<String> alergiasCliente = cliente.getAlergias();
        List<String> restricoesAlimentar = cliente.getRestricoesAlimentar();

        if (alergiasCliente.contains("Amendoim")) {
            System.out.println("Atenção: Cliente tem alergia a amendoim!");
        }
        if (restricoesAlimentar.contains("Lactose")) {
            System.out.println("Atenção: Cliente tem intolerancia a Lactose!");
        }

    }
}

