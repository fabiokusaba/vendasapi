package com.fabiokusaba.vendas_api.api.v1.request.venda.cadastrar;

import com.fabiokusaba.vendas_api.api.v1.request.venda.ItemVendaRequest;
import com.fabiokusaba.vendas_api.domain.model.Venda;
import com.fabiokusaba.vendas_api.domain.vo.ItemVenda;

import java.util.List;

public record CadastrarVendaRequest(
        String clienteId,
        List<ItemVendaRequest> itens
) {

    public static Venda toVenda(CadastrarVendaRequest request) {
        return Venda.novaVenda(
                request.clienteId(),
                request.itens().stream()
                        .map(item -> ItemVenda.novoItemVenda(
                                item.produtoId(),
                                null,
                                null,
                                item.quantidade(),
                                null
                        ))
                        .toList()
        );
    }
}
