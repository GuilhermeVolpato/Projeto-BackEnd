package com.sistemalanchonete.sistemalanchonete.repository;

import com.sistemalanchonete.sistemalanchonete.model.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface MesaRepository extends JpaRepository<Mesa, Long>, QuerydslPredicateExecutor<Mesa> {
}
