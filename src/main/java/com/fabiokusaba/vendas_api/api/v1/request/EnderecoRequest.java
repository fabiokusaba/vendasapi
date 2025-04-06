package com.fabiokusaba.vendas_api.api.v1.request;

public record EnderecoRequest(
        String cep,
        String uf,
        String cidade,
        String bairro,
        String logradouro,
        String complemento,
        String numero
) {
}
