package com.fabiokusaba.vendas_api.api.v1.response.cliente.buscar;

import com.fabiokusaba.vendas_api.api.v1.response.EnderecoResponse;
import com.fabiokusaba.vendas_api.domain.model.Cliente;

public record BuscarClienteResponse(
        String id,
        String nome,
        String cpf,
        EnderecoResponse endereco
) {

    public static BuscarClienteResponse fromModel(Cliente cliente) {
        return new BuscarClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                EnderecoResponse.toModel(cliente)
        );
    }
}
