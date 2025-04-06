package com.fabiokusaba.vendas_api.api.v1.response.cliente.cadastrar;

import com.fabiokusaba.vendas_api.api.v1.response.EnderecoResponse;
import com.fabiokusaba.vendas_api.domain.model.Cliente;

public record CadastrarClienteResponse(
        String id,
        String nome,
        String cpf,
        EnderecoResponse endereco
) {

    public static CadastrarClienteResponse fromModel(Cliente cliente) {
        return new CadastrarClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                EnderecoResponse.toModel(cliente)
        );
    }
}
