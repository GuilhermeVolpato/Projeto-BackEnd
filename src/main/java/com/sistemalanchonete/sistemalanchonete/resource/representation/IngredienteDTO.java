package com.sistemalanchonete.sistemalanchonete.resource.representation;

public class IngredienteDTO {
        private Long id;
        private String nome;
        private String quantidadeMinima;
        private String quantidadeTotal;
        private String dtValidade;
        private String precoCompra;
        private String temperaturaArmazenamento;
        private String estoque;
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

