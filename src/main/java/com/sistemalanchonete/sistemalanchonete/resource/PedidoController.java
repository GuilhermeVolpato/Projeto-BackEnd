package com.sistemalanchonete.sistemalanchonete.resource;

import com.sistemalanchonete.sistemalanchonete.model.Pedido;
import com.sistemalanchonete.sistemalanchonete.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("/local")
    public Pedido criarPedidoLocal(@RequestBody Pedido pedido) {
        // Lógica para criar um pedido feito no local
        return pedidoService.criarPedidoLocal(pedido);
    }

//    @PostMapping("/online")
//    public Pedido criarPedidoOnline(@RequestBody Pedido pedido) {
//        // Lógica para criar um pedido feito online
//        return pedidoService.criarPedidoOnline(pedido);
//    }
}

