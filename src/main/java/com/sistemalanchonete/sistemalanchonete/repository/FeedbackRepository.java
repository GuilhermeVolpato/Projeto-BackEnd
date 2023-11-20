package com.sistemalanchonete.sistemalanchonete.repository;

import com.sistemalanchonete.sistemalanchonete.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, String>, QuerydslPredicateExecutor<Feedback> {
}