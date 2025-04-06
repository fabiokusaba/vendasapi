package com.fabiokusaba.vendas_api.api.v1.request.cliente.atualizar;

import com.fabiokusaba.vendas_api.domain.model.Cliente;
import com.fabiokusaba.vendas_api.domain.vo.Endereco;

public record AtualizarClienteRequest(
        String nome,
        String cpf,
        Endereco endereco
) {

    public static Cliente toModel(AtualizarClienteRequest request) {
        return Cliente.novoCliente(
                request.nome(),
                request.cpf(),
                request.endereco()
        );
    }
}
