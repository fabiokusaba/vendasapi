package com.fabiokusaba.vendas_api.api.v1.request;

import com.fabiokusaba.vendas_api.domain.vo.Endereco;

public record EnderecoRequest(
        String cep,
        String uf,
        String cidade,
        String bairro,
        String logradouro,
        String complemento,
        String numero
) {

    public static Endereco toModel(EnderecoRequest request) {
        return Endereco.novoEndereco(
                request.cep(),
                request.uf(),
                request.cidade(),
                request.bairro(),
                request.logradouro(),
                request.complemento(),
                request.numero()
        );
    }
}
