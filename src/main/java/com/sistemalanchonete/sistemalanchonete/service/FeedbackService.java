package com.sistemalanchonete.sistemalanchonete.service;

import com.sistemalanchonete.sistemalanchonete.model.Feedback;
import com.sistemalanchonete.sistemalanchonete.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository repository;

    public Feedback salvar(Feedback entity){
        return repository.save(entity);
    }
}
