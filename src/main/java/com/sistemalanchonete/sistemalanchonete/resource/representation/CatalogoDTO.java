package com.sistemalanchonete.sistemalanchonete.resource.representation;

import com.sistemalanchonete.sistemalanchonete.model.Catalogo;
import com.sistemalanchonete.sistemalanchonete.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

public class CatalogoDTO {
        private Long id;
        private String itens_venda;
        private String itensvendas;
        private String nome;

    public static CatalogoDTO fromEntity(Catalogo catalogo) {
        CatalogoDTO dto = new CatalogoDTO();
        dto.setId(catalogo.getId());
        dto.setNome(catalogo.getNome());
        return dto;
    }

    public Cliente toEntity() {
        Cliente Cliente = new Cliente();
        Cliente.setId(this.getId());
        Cliente.setNome(this.getNome());
        return Cliente;
    }

    public static List<CatalogoDTO> fromEntity(List<Catalogo> catalogos) {
        return catalogos.stream().map(catalogo -> fromEntity(catalogo)).collect(Collectors.toList());
    }

    public static Page<CatalogoDTO> fromEntity(Page<Catalogo> catalogos) {
        List<CatalogoDTO> catalogoFind = catalogos.stream().map(catalogo -> fromEntity(catalogo)).collect(Collectors.toList());
        Page<CatalogoDTO> catalogoDTOS = new PageImpl<>(catalogoFind, catalogos.getPageable(), catalogos.getTotalElements());
        return catalogoDTOS;
    }

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
