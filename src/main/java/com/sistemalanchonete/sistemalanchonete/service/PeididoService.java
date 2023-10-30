//Registro de Pedidos:
//
//        Somente os funcionários autorizados têm permissão para registrar pedidos no sistema.
//        Cada pedido deve incluir informações detalhadas, como itens selecionados, quantidade, mesa ou cliente associado e a hora do pedido.
//        Controle de Estoque:

package com.sistemalanchonete.sistemalanchonete.service;

import com.sistemalanchonete.sistemalanchonete.model.Atendente;
import com.sistemalanchonete.sistemalanchonete.model.Pedido;
import com.sistemalanchonete.sistemalanchonete.model.Situacao;
import com.sistemalanchonete.sistemalanchonete.repository.AtendenteRepository;
import com.sistemalanchonete.sistemalanchonete.repository.ClienteRepository;
import com.sistemalanchonete.sistemalanchonete.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;

@Service
public class PeididoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AtendenteRepository atendenteRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    public Pedido salvar(Pedido pedido) {

        if (pedido.getAtendente() != null && pedido.getAtendente().getId() != null &&
                pedido.getCliente() != null && pedido.getCliente().getId() != null) {
            Atendente atendente = atendenteRepository.findById(pedido.getAtendente().getId()).orElse(null);
            if (atendente != null && atendente.getSituacao() == Situacao.ATIVO) {
                return repository.save(pedido);
            } else {
                throw new RuntimeException("Atendente não está ativo ou é inválido");
            }
        } else {
            throw new RuntimeException("ID de Atendente e/ou Cliente inválido(s)");
        }
    }
}

