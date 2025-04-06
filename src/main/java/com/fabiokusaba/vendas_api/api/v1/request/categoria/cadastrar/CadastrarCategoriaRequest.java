package com.fabiokusaba.vendas_api.api.v1.request.categoria.cadastrar;

import com.fabiokusaba.vendas_api.domain.model.Categoria;

public record CadastrarCategoriaRequest(
        String nome,
        String descricao
) {

    public static Categoria toModel(CadastrarCategoriaRequest request) {
        return Categoria.novaCategoria(request.nome(), request.descricao());
    }
}
