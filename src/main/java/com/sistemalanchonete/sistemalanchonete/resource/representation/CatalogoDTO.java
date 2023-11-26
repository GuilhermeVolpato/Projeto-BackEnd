package com.sistemalanchonete.sistemalanchonete.resource.representation;

public class CatalogoDTO {
        private Long id;
        private String itens_venda;
        private String itensvendas;
        private String nome;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getItens_venda() {  return itens_venda;
        }

        public void setItens_venda(String itensVenda) {this.itens_venda = itens_venda;
        }

        public String getItensvendas() {
            return itensvendas;
        }

        public void setItensvendas(String itensvendas) {
            this.itensvendas = itensvendas;
        }

}
