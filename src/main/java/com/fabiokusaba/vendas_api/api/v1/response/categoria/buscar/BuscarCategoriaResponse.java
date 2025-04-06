package com.fabiokusaba.vendas_api.api.v1.response.categoria.buscar;

import com.fabiokusaba.vendas_api.domain.model.Categoria;

public record BuscarCategoriaResponse(
        String id,
        String nome,
        String descricao
) {

    public static BuscarCategoriaResponse fromModel(Categoria categoria) {
        return new BuscarCategoriaResponse(
                categoria.getId(),
                categoria.getNome(),
                categoria.getDescricao()
        );
    }
}
