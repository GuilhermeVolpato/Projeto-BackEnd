package com.sistemalanchonete.sistemalanchonete.repository;

import com.sistemalanchonete.sistemalanchonete.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendenteRepository extends JpaRepository<Funcionario, Long>, QuerydslPredicateExecutor<Funcionario> {
}
