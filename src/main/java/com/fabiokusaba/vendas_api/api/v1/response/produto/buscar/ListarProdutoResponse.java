package com.fabiokusaba.vendas_api.api.v1.response.produto.buscar;

import com.fabiokusaba.vendas_api.domain.model.Produto;

import java.util.List;
import java.util.stream.Collectors;

public record ListarProdutoResponse(
        String id,
        String nome,
        String descricao,
        List<String> categorias,
        String codigoDeBarras,
        Double preco,
        Integer quantidade,
        Boolean ativo
) {

    private static ListarProdutoResponse fromModel(Produto produto) {
        return new ListarProdutoResponse(
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

    public static List<ListarProdutoResponse> fromModelList(List<Produto> produtos) {
        return produtos.stream()
                .map(ListarProdutoResponse::fromModel)
                .collect(Collectors.toList());
    }
}
