package com.fabiokusaba.vendas_api.domain.vo;

public class ItemVenda {

    private String produtoId;
    private String nome;
    private Double preco;
    private Integer quantidade;
    private Double precoTotal;

    public ItemVenda(String produtoId, String nome, Double preco, Integer quantidade) {
        this.produtoId = produtoId;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.precoTotal = preco;
    }

    public static ItemVenda novoItemVenda(String produtoId, String nome, Double preco, Integer quantidade) {
        return new ItemVenda(produtoId, nome, preco, quantidade);
    }

    public String getProdutoId() {
        return produtoId;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setProdutoId(String produtoId) {
        this.produtoId = produtoId;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }
}
