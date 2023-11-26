//Registro de Pedidos:
//
//        Somente os funcionários autorizados têm permissão para registrar pedidos no sistema.
//        Cada pedido deve incluir informações detalhadas, como itens selecionados, quantidade, mesa ou cliente associado e a hora do pedido.
//        Controle de Estoque:

package com.sistemalanchonete.sistemalanchonete.service;

import com.sistemalanchonete.sistemalanchonete.model.Cliente;
import com.sistemalanchonete.sistemalanchonete.model.Funcionario;
import com.sistemalanchonete.sistemalanchonete.model.ItemPedido;
import com.sistemalanchonete.sistemalanchonete.model.Pedido;
import com.sistemalanchonete.sistemalanchonete.repository.AtendenteRepository;
import com.sistemalanchonete.sistemalanchonete.repository.ClienteRepository;
import com.sistemalanchonete.sistemalanchonete.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;
    private final ItensPedidoService itemPedidoService;
    private final ClienteService clienteService;
    private final FuncionarioService funcionarioService;
    private final MesaService mesaService;

    @Autowired
    public PedidoService(ItensPedidoService itemPedidoService,
                         ClienteService clienteService,
                         FuncionarioService funcionarioService,
                         MesaService mesaService) {
        this.itemPedidoService = itemPedidoService;
        this.clienteService = clienteService;
        this.funcionarioService = funcionarioService;
        this.mesaService = mesaService;
    }


    public Pedido criarPedidoLocal(Pedido pedido) {

        if (pedido.getCliente() != null && pedido.getCliente().getId() != null) {
            pedido.setCliente(clienteService.buscarPorId(pedido.getCliente().getId()));
        }

        if (pedido.getFuncionario() != null && pedido.getFuncionario().getId() != null) {
            pedido.setFuncionario(funcionarioService.buscarPorId(pedido.getFuncionario().getId()));
        }

        if (pedido.getMesa() != null && pedido.getMesa().getId() != null) {
            pedido.setMesa(mesaService.buscarPorId(pedido.getMesa().getId()));
        }

        if(pedido.getPedidoWeb() == null){
            pedido.setPedidoWeb(false);
        }


        pedido = repository.save(pedido);


        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setPedido(pedido);
        if(itemPedido.getQtde() == null){
            itemPedido.setQtde(1L);
        }
        itemPedidoService.salvar(Collections.singletonList(itemPedido));

        return pedido;
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

