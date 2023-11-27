package com.sistemalanchonete.sistemalanchonete.model;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    public Entity() {
    }

    public Entity(String rua, String cep) {
    }

    public Entity(String nome, Double quantidadeTotal, Double quantidadeMinima, Date dtValidade, Double precoCompra, Double temperaturaArmazenamento) {
    }

    public Entity(ItensVenda item, Pedido pedido, Long qtde) {
    }

    public Long getId() {
        return id;
    }

    public static void setId(Long id) {
    }
}
