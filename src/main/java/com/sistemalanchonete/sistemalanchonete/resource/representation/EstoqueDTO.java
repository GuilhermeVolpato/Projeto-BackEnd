package com.sistemalanchonete.sistemalanchonete.resource.representation;

import com.sistemalanchonete.sistemalanchonete.model.Estoque;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

public class EstoqueDTO {
    private Long id;
    private String compartimento;
    private String qtdeIngredientes;
    private String ingrediente;


    public static EstoqueDTO fromEntity(Estoque estoque) {
        EstoqueDTO dto = new EstoqueDTO();
        dto.setId(estoque.getId());
        dto.setIngrediente(estoque.getIngredientes());

        return dto;
    }

    public Estoque toEntity() {
        Estoque estoque = new Estoque();
        Estoque.setId(this.getId());
        return estoque;
    }


    public static List<EstoqueDTO> fromEntity(List<Estoque> estoques) {
        return estoques.stream().map(estoque -> fromEntity(estoque)).collect(Collectors.toList());
    }

    public static Page<EstoqueDTO> fromEntity(Page<Estoque> estoques) {
        List<EstoqueDTO> estoqueFind = estoques.stream().map(estoque -> fromEntity(estoque)).collect(Collectors.toList());
        Page<EstoqueDTO> estoqueDTOS = new PageImpl<>(estoqueFind, estoques.getPageable(), estoques.getTotalElements());
        return estoqueDTOS;
    }

    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompartimento() {
        return compartimento;
    }

    public void setCompartimento(String compartimento) {
        this.compartimento = compartimento;
    }

    public String getQtdeIngredientes() {
        return qtdeIngredientes;
    }

    public void setQtdeIngredientes(String qtdeIngredientes) {this.qtdeIngredientes = qtdeIngredientes; }

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }
}
