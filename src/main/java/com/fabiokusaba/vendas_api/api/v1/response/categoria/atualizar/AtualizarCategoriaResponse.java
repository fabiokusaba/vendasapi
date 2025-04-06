package com.fabiokusaba.vendas_api.api.v1.response.categoria.atualizar;

import com.fabiokusaba.vendas_api.domain.model.Categoria;

public record AtualizarCategoriaResponse(
        String id,
        String nome,
        String descricao
) {

    public static AtualizarCategoriaResponse fromModel(Categoria categoria) {
        return new AtualizarCategoriaResponse(
                categoria.getId(),
                categoria.getNome(),
                categoria.getDescricao()
        );
    }
}
