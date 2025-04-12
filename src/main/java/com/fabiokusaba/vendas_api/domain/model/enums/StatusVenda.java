package com.fabiokusaba.vendas_api.domain.model.enums;

public enum StatusVenda {

    ABERTA(1),
    FECHADA(2);

    private Integer codigo;

    StatusVenda(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public static StatusVenda fromCodigo(Integer codigo) {
        for (StatusVenda status : StatusVenda.values()) {
            if (status.getCodigo() == codigo) {
                return status;
            }
        }
        throw new IllegalArgumentException("Código inválido: " + codigo);
    }
}
