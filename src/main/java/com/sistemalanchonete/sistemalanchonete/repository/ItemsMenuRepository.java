package com.sistemalanchonete.sistemalanchonete.repository;

import com.sistemalanchonete.sistemalanchonete.model.ItemsMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ItemsMenuRepository extends JpaRepository<ItemsMenu, Long>, QuerydslPredicateExecutor<ItemsMenu> {
}
