package com.sistemalanchonete.sistemalanchonete.repository;

import com.sistemalanchonete.sistemalanchonete.model.Catalogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CatalogoRepository extends JpaRepository<Catalogo, Long>, QuerydslPredicateExecutor<Catalogo> {
}
