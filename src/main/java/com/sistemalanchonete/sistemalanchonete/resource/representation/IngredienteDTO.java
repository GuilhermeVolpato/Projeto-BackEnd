package com.sistemalanchonete.sistemalanchonete.resource.representation;

import com.sistemalanchonete.sistemalanchonete.model.Cliente;
import com.sistemalanchonete.sistemalanchonete.model.Ingrediente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

public class IngredienteDTO {
        private Long id;
        private String nome;
        private String quantidadeMinima;
        private String quantidadeTotal;
        private String dtValidade;
        private String precoCompra;
        private String temperaturaArmazenamento;
        private String estoque;

    public static IngredienteDTO fromEntity(Ingrediente ingrediente) {
        IngredienteDTO dto = new IngredienteDTO();
        dto.setId(ingrediente.getId());
        dto.setNome(ingrediente.getNome());
        return dto;
    }

    public Ingrediente toEntity() {
        Ingrediente Ingrediente = new Ingrediente();
        Ingrediente.setId(this.getId());
        Ingrediente.setNome(this.getNome());
        return Ingrediente;
    }

    public static List<IngredienteDTO> fromEntity(List<Ingrediente> ingredientes) {
        return ingredientes.stream().map(ingrediente -> fromEntity(ingrediente)).collect(Collectors.toList());
    }

    public static Page<IngredienteDTO> fromEntity(Page<Ingrediente> ingredientes) {
        List<IngredienteDTO> ingredienteFind = ingredientes.stream().map(ingrediente -> fromEntity(ingrediente)).collect(Collectors.toList());
        Page<IngredienteDTO> ingredienteDTOS = new PageImpl<>(ingredienteFind, ingredientes.getPageable(), ingredientes.getTotalElements());
        return ingredienteDTOS;
    }
        public Long getId() {return id;}

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getQuantidadeMinima() {
            return quantidadeMinima;
        }

        public void setQuantidadeMinima(String quantidadeMinima) {this.quantidadeMinima = quantidadeMinima; }

        public String getQuantidadeTotal() {
            return quantidadeTotal;
        }

        public void setQuantidadeTotal(String quantidadeTotal) {
            this.quantidadeTotal = quantidadeTotal;
        }

        public String getDtValidade() {
            return dtValidade;
        }

        public void setDtValidade(String dtValidade) {this.dtValidade = dtValidade; }

        public String getPrecoCompra() {
            return precoCompra;
        }

        public void setPrecoCompra(String precoCompra) {
            this.precoCompra = precoCompra;
        }

        public String getTemperaturaArmazenamento() {
            return temperaturaArmazenamento;
        }

        public void setTemperaturaArmazenamento(String temperaturaArmazenamento) {this.dtValidade = temperaturaArmazenamento; }

        public String getEstoque() {
            return estoque;
        }

        public void setEstoque(String estoque) {this.estoque = estoque;        }
            }

