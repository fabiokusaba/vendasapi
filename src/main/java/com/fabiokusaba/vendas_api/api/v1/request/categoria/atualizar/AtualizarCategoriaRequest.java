package com.fabiokusaba.vendas_api.api.v1.request.categoria.atualizar;

import com.fabiokusaba.vendas_api.domain.model.Categoria;

public record AtualizarCategoriaRequest(
        String nome,
        String descricao
) {

    public static Categoria toModel(AtualizarCategoriaRequest request) {
        return Categoria.novaCategoria(
                request.nome(),
                request.descricao()
        );
    }
}
