package com.fabiokusaba.vendas_api.api.v1.response.produto.atualizar;

import com.fabiokusaba.vendas_api.domain.model.Produto;

import java.util.List;

public record AtualizarProdutoResponse(
        String id,
        String nome,
        String descricao,
        List<String> categorias,
        String codigoDeBarras,
        Double preco,
        Integer quantidade,
        Boolean ativo
) {

    public static AtualizarProdutoResponse fromModel(Produto produto) {
        return new AtualizarProdutoResponse(
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
