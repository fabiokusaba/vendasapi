package com.fabiokusaba.vendas_api.api.v1.request;

public record CadastrarClienteRequest(
        String nome,
        String cpf,
        EnderecoRequest endereco
) {
}
