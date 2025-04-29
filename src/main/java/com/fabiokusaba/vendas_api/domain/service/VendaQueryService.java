package com.fabiokusaba.vendas_api.domain.service;

import com.fabiokusaba.vendas_api.domain.filter.VendaFilter;
import com.fabiokusaba.vendas_api.domain.model.Venda;
import com.fabiokusaba.vendas_api.domain.pagination.Pagination;

public interface VendaQueryService {

    Pagination<Venda> listar(VendaFilter filter);
}
