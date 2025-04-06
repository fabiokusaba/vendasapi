package com.fabiokusaba.vendas_api.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Document(collection = "produto")
public class Produto {

    @Id
    private String id;
    private String nome;
    private String descricao;
    private List<String> categorias;
    private String codigoDeBarras;
    private Double preco;
    private Integer quantidade;
    private Boolean ativo;

    private Produto(String id, String nome, String descricao, List<String> categorias, String codigoDeBarras, Double preco, Integer quantidade, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.categorias = categorias;
        this.codigoDeBarras = codigoDeBarras;
        this.preco = preco;
        this.quantidade = quantidade;
        this.ativo = ativo;
    }

    public static Produto novoProduto(String nome, String descricao, List<String> categorias, String codigoDeBarras, Double preco, Integer quantidade) {
        final var id = UUID.randomUUID().toString();
        return new Produto(id, nome, descricao, categorias, codigoDeBarras, preco, quantidade, true);
    }

    public Produto atualizarProduto(String nome, String descricao, List<String> categorias, String codigoDeBarras, Double preco, Integer quantidade) {
        if (StringUtils.hasText(codigoDeBarras)) {
            this.codigoDeBarras = codigoDeBarras;
        }
        this.nome = nome;
        this.descricao = descricao;
        this.categorias = categorias;
        this.preco = preco;
        this.quantidade = quantidade;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Boolean getAtivo() {
        return ativo;
    }
}
