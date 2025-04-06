package com.fabiokusaba.vendas_api.api.v1.response.categoria.cadastrar;

import com.fabiokusaba.vendas_api.domain.model.Categoria;

public record CadastrarCategoriaResponse(
        String id,
        String nome,
        String descricao
) {

    public static CadastrarCategoriaResponse fromModel(Categoria categoria) {
        return new CadastrarCategoriaResponse(
                categoria.getId(),
                categoria.getNome(),
                categoria.getDescricao()
        );
    }
}
