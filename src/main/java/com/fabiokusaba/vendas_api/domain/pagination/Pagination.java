package com.fabiokusaba.vendas_api.domain.pagination;

import java.util.List;

public record Pagination<T>(
        Integer pagina,
        Integer qtdPorPagina,
        Long total,
        List<T> resultado
) {
}
