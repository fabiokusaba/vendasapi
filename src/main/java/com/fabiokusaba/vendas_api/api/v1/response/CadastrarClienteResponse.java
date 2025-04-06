package com.fabiokusaba.vendas_api.api.v1.response;

public record CadastrarClienteResponse(
        String id,
        String nome,
        String cpf,
        EnderecoResponse endereco
) {
}
