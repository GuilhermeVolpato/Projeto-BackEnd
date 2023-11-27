package com.sistemalanchonete.sistemalanchonete.repository;

import com.sistemalanchonete.sistemalanchonete.enterprise.CustomQuerydslPredicateExecutor;
import com.sistemalanchonete.sistemalanchonete.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long>, CustomQuerydslPredicateExecutor<Estoque> {
}
