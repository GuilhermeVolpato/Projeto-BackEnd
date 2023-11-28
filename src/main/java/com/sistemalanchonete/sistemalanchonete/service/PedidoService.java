//Registro de Pedidos:
//
//        Somente os funcionários autorizados têm permissão para registrar pedidos no sistema.
//        Cada pedido deve incluir informações detalhadas, como itens selecionados, quantidade, mesa ou cliente associado e a hora do pedido.
//        Controle de Estoque:

package com.sistemalanchonete.sistemalanchonete.service;

import com.sistemalanchonete.sistemalanchonete.model.*;
import com.sistemalanchonete.sistemalanchonete.repository.AtendenteRepository;
import com.sistemalanchonete.sistemalanchonete.repository.ClienteRepository;
import com.sistemalanchonete.sistemalanchonete.repository.PedidoRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
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
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setPedido(pedido);

        if (itemPedido.getQtde() == null) {
            itemPedido.setQtde(1L);
        }

        if (pedido.getCliente() != null && pedido.getCliente().getId() != null) {
            pedido.setCliente(clienteService.buscarPorId(pedido.getCliente().getId()));
        }

        if (pedido.getFuncionario() != null && pedido.getFuncionario().getId() != null) {
            pedido.setFuncionario(funcionarioService.buscarPorId(pedido.getFuncionario().getId()));
        }

        if (pedido.getMesa() != null && pedido.getMesa().getId() != null) {
            pedido.setMesa(mesaService.buscarPorId(pedido.getMesa().getId()));
        }

        if (pedido.getPedidoWeb() == null) {
            pedido.setPedidoWeb(false);
        }

        // Os clientes podem escolher entre retirar pessoalmente ou receber a entrega em um endereço específico.
        if (pedido.getTipoEntrega().equals(Entrega.ENTREGA)) {
            pedido.getCliente().getEnderecos().add(pedido.getEndereco());
            pedido.setEndereco(pedido.getEndereco());
            System.out.println("Pedido de entrega");
        } else if (pedido.getTipoEntrega().equals(Entrega.RETIRADA)) {
            pedido.setEndereco(null);
        }


//        if (itemPedido.getItem() != null && itemPedido.getItem().getIngredientes() != null) {
//
//            Ingrediente ingrediente = itemPedido.getItem().getIngredientes();
//            System.out.println(ingrediente.getQuantidadeAtual());
//            if (ingrediente.getQuantidadeAtual() == 0) {
//                throw new IllegalArgumentException("Ingrediente não disponível em quantidade suficiente no estoque.");
//            }
//        }

            if(pedido.getCliente().getAlergias() !=  null){
                System.out.println("Cliente possui alergias");
            }

            Double valorTotalPedido;
            if(pedido.getValorDesconto() >= 1){
                valorTotalPedido = pedido.getValorTotal() - pedido.getValorDesconto();
            }else{
                valorTotalPedido = pedido.getValorTotal();
            }

            pedido.setValorFinal(valorTotalPedido);
            pedido = repository.save(pedido);

            itemPedidoService.salvar(Collections.singletonList(itemPedido));

            return pedido;
        }
}


