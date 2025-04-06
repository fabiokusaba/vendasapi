package com.fabiokusaba.vendas_api.api.v1.response.categoria.buscar;

import com.fabiokusaba.vendas_api.domain.model.Categoria;

import java.util.List;
import java.util.stream.Collectors;

public record ListarCategoriaResponse(
        String id,
        String nome,
        String descricao
) {

    private static ListarCategoriaResponse fromModel(Categoria categoria) {
        return new ListarCategoriaResponse(
                categoria.getId(),
                categoria.getNome(),
                categoria.getDescricao()
        );
    }

    public static List<ListarCategoriaResponse> fromModelList(List<Categoria> categorias) {
        return categorias.stream()
                .map(ListarCategoriaResponse::fromModel)
                .collect(Collectors.toList());
    }
}
