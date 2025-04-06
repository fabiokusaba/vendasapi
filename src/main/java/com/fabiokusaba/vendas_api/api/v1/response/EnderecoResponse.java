package com.fabiokusaba.vendas_api.api.v1.response;

import com.fabiokusaba.vendas_api.domain.model.Cliente;
import com.fabiokusaba.vendas_api.domain.vo.Endereco;

public record EnderecoResponse(
        String cep,
        String uf,
        String cidade,
        String bairro,
        String logradouro,
        String complemento,
        String numero
) {

    public static EnderecoResponse toModel(Cliente cliente) {
        return new EnderecoResponse(
                cliente.getEndereco().getCep(),
                cliente.getEndereco().getUf(),
                cliente.getEndereco().getCidade(),
                cliente.getEndereco().getBairro(),
                cliente.getEndereco().getLogradouro(),
                cliente.getEndereco().getComplemento(),
                cliente.getEndereco().getNumero()
        );
    }
}
