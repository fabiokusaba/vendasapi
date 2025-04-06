package com.fabiokusaba.vendas_api.api.v1.response.produto.cadastrar;

import com.fabiokusaba.vendas_api.domain.model.Produto;

import java.util.List;

public record CadastrarProdutoResponse(
        String id,
        String nome,
        String descricao,
        List<String> categorias,
        String codigoDeBarras,
        Double preco,
        Integer quantidade,
        Boolean ativo
) {

    public static CadastrarProdutoResponse fromModel(Produto produto) {
        return new CadastrarProdutoResponse(
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
