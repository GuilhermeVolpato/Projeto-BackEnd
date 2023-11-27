package com.sistemalanchonete.sistemalanchonete.repository;

import com.sistemalanchonete.sistemalanchonete.model.ItensVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItensVendaRepository extends JpaRepository<ItensVenda, Long>, QuerydslPredicateExecutor<ItensVenda> {

    @Query("SELECT i FROM ItensVenda i WHERE i.isOff = true")
    List<ItensVenda> buscarItensEmPromocao();
}
