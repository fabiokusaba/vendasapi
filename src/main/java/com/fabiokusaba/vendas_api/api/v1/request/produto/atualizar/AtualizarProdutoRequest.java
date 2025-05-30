package com.fabiokusaba.vendas_api.api.v1.request.produto.atualizar;

import com.fabiokusaba.vendas_api.domain.model.Produto;

import java.util.List;

public record AtualizarProdutoRequest(
        String nome,
        String descricao,
        List<String> categorias,
        String codigoDeBarras,
        Double preco,
        Integer quantidade
) {

    public static Produto toModel(AtualizarProdutoRequest request) {
        return Produto.novoProduto(
                request.nome(),
                request.descricao(),
                request.categorias(),
                request.codigoDeBarras(),
                request.preco(),
                request.quantidade()
        );
    }
}
