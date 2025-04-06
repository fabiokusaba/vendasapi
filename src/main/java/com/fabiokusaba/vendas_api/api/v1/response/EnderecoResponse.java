package com.fabiokusaba.vendas_api.api.v1.response;

public record EnderecoResponse(
        String cep,
        String uf,
        String cidade,
        String bairro,
        String logradouro,
        String complemento,
        String numero
) {
}
