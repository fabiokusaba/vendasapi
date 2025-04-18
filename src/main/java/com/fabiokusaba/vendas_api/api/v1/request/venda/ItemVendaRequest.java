package com.fabiokusaba.vendas_api.api.v1.request.venda;

import com.fabiokusaba.vendas_api.domain.vo.ItemVenda;

public record ItemVendaRequest(
        String produtoId,
        Integer quantidade
) {

    public static ItemVenda toItemVenda(ItemVendaRequest request) {
        return ItemVenda.novoItemVenda(request.produtoId(), null, null, request.quantidade(), null);
    }
}
