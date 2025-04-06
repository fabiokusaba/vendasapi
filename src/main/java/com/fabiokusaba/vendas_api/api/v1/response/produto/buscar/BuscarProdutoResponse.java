package com.fabiokusaba.vendas_api.api.v1.response.produto.buscar;

import com.fabiokusaba.vendas_api.domain.model.Produto;

import java.util.List;

public record BuscarProdutoResponse(
    String id,
    String nome,
    String descricao,
    List<String> categorias,
    String codigoDeBarras,
    Double preco,
    Integer quantidade,
    Boolean ativo
) {

    public static BuscarProdutoResponse fromModel(Produto produto) {
        return new BuscarProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getCategorias(),
                produto.getCodigoDeBarras(),
                produto.getPreco(),
                produto.getQuantidade(),
                produto.getAtivo()
        );
    }
}
