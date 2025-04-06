package com.fabiokusaba.vendas_api.api.v1.response.cliente.buscar;

import com.fabiokusaba.vendas_api.api.v1.response.EnderecoResponse;
import com.fabiokusaba.vendas_api.domain.model.Cliente;

import java.util.List;
import java.util.stream.Collectors;

public record ListarClienteResponse(
        String id,
        String nome,
        String cpf,
        EnderecoResponse endereco
) {

    private static ListarClienteResponse fromModel(Cliente cliente) {
        return new ListarClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                EnderecoResponse.toModel(cliente)
        );
    }

    public static List<ListarClienteResponse> fromModelList(List<Cliente> clientes) {
        return clientes.stream()
                .map(ListarClienteResponse::fromModel)
                .collect(Collectors.toList());
    }
}
