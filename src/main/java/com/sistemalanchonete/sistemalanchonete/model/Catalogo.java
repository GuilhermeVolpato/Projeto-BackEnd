package com.sistemalanchonete.sistemalanchonete.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
@Table(name = "Catalogos")
public class Catalogo extends Entity {

    @JoinColumn(name = "itensVendas_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItensVenda> itensVendas;

    @Column(name = "nome", nullable = false)
    private String nome;

    // Relacionamento com Itens_venda
    @ManyToOne
    @JoinColumn(name = "itens_venda", nullable = false)
    private ItensVenda itensVenda;



    // Regra de Negócio: Ordenação por popularidade
    private List<ItemMenu> itens;

    public List<ItemMenu> ordenarPorPopularidade() {
        // Lógica para ordenar itens por popularidade
    }

     //teste
    // Regra de Negócio: Retornar Itens com Base no Estoque
    public List<ItensVenda> obterItensDisponiveis() {
        List<ItensVenda> itensDisponiveis = new ArrayList<>();

        for (ItensVenda itensVenda : itensVendas) {
            if (itensVenda.isDisponivelEmEstoque()) {
                itensDisponiveis.add(itensVenda);
            }
        }

        return itensDisponiveis;
    }

    // Regra de Negócio: Retornar Itens em Promoção
    public List<ItensVenda> obterItensEmPromocao() {
        List<ItensVenda> itensEmPromocao = new ArrayList<>();

        for (ItensVenda itensVenda : itensVendas) {
            if (itensVenda.isEmPromocao()) {
                itensEmPromocao.add(itensVenda);
            }
        }

        return itensEmPromocao;
    }

    public Catalogo() {
        super();
        this.itensVendas = new ArrayList<>(); // Initialize the list
    }

    // Construtor com campos
    public Catalogo(String nome, String itensVenda, ItensVenda itensVendas ) {
        super();
        this.itensVendas = new ArrayList<>(List.of(itensVendas));
        }
    private String formatarItensVenda() {
        if (itensVendas != null && !itensVendas.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ItensVenda itensVendas : itensVendas) {
                sb.append(itensVendas.toString()).append("; ");
            }
            return sb.toString();
        }
        return "Sem itens Vendas";
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ItensVenda getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(ItensVenda itensVenda) {
        this.itensVendas = itensVendas;
    }
    public List<ItensVenda> getItensVendas() {
        return itensVendas;
    }

    // Correção aqui - utilize um método específico para setar os endereços
    public void setItensVendas(List<ItensVenda> itensVendas) { this.itensVendas = itensVendas;
    }
}
