package com.sistemalanchonete.sistemalanchonete.repository;

import com.sistemalanchonete.sistemalanchonete.model.ItensVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ItensVendaRepository extends JpaRepository<ItensVenda, Long>, QuerydslPredicateExecutor<ItensVenda> {
}
