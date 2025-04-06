package com.fabiokusaba.vendas_api.api.v1.request;

import com.fabiokusaba.vendas_api.domain.model.Cliente;

public record CadastrarClienteRequest(
        String nome,
        String cpf,
        EnderecoRequest endereco
) {

    public static Cliente toModel(CadastrarClienteRequest request) {
        return Cliente.novoCliente(
                request.nome(),
                request.cpf(),
                EnderecoRequest.toModel(request.endereco())
        );
    }
}
