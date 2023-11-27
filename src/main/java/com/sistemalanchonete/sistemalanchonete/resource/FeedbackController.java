package com.sistemalanchonete.sistemalanchonete.resource;

import com.sistemalanchonete.sistemalanchonete.model.Estoque;
import com.sistemalanchonete.sistemalanchonete.model.Feedback;
import com.sistemalanchonete.sistemalanchonete.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService service;

    @PostMapping("/Cadastro")
    public ResponseEntity<Feedback> create(@RequestBody Feedback feedback){
        Feedback novoFeedback = service.salvar(feedback);
        return ResponseEntity.ok(novoFeedback);
    }
}
