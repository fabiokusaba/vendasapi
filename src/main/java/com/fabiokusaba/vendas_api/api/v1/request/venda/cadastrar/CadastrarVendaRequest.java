package com.fabiokusaba.vendas_api.api.v1.request.venda.cadastrar;

import com.fabiokusaba.vendas_api.api.v1.request.venda.ItemVendaRequest;

import java.util.List;

public record CadastrarVendaRequest(
        String clienteId,
        List<ItemVendaRequest> itens
) {
}
