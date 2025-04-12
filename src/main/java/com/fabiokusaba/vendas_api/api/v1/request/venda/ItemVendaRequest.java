package com.fabiokusaba.vendas_api.api.v1.request.venda;

public record ItemVendaRequest(
        String produtoId,
        Integer quantidade
) {
}
