package com.sistemalanchonete.sistemalanchonete.repository;
import com.sistemalanchonete.sistemalanchonete.model.Compartimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CompartimentoRepository extends JpaRepository<Compartimento, Long>, QuerydslPredicateExecutor<Compartimento> {
}
