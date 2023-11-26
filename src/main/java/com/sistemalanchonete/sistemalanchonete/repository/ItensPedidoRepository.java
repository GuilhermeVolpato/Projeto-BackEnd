package com.sistemalanchonete.sistemalanchonete.repository;


import com.sistemalanchonete.sistemalanchonete.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ItensPedidoRepository extends JpaRepository<ItemPedido, Long>, QuerydslPredicateExecutor<ItemPedido> {
}
