package com.fabiokusaba.vendas_api.api.v1.response.cliente.atualizar;

import com.fabiokusaba.vendas_api.domain.model.Cliente;
import com.fabiokusaba.vendas_api.domain.vo.Endereco;

public record AtualizarClienteResponse(
        String id,
        String nome,
        String cpf,
        Endereco endereco
) {

    public static AtualizarClienteResponse fromModel(Cliente cliente) {
        return new AtualizarClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                Endereco.novoEndereco(
                        cliente.getEndereco().getCep(),
                        cliente.getEndereco().getUf(),
                        cliente.getEndereco().getCidade(),
                        cliente.getEndereco().getBairro(),
                        cliente.getEndereco().getLogradouro(),
                        cliente.getEndereco().getComplemento(),
                        cliente.getEndereco().getNumero()
                )
        );
    }
}
