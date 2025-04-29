package com.fabiokusaba.vendas_api.domain.filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class VendaFilter {

    private String clienteId;
    @DateTimeFormat(pattern = "yyyy-MM-dd") // Formato ano-mês-dia
    private LocalDate dataInicio;
    @DateTimeFormat(pattern = "yyyy-MM-dd") // Formato ano-mês-dia
    private LocalDate dataFim;
    private Integer pagina = 1;
    private Integer qtdPorPagina = 10;
    private String tipoOrdenacao = "desc";
    private String ordenarPor = "data";

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Integer getPagina() {
        return this.pagina > 0 ? this.pagina - 1 : 0;
    }

    public void setPagina(Integer pagina) {
        this.pagina = pagina;
    }

    public Integer getQtdPorPagina() {
        return qtdPorPagina;
    }

    public void setQtdPorPagina(Integer qtdPorPagina) {
        this.qtdPorPagina = qtdPorPagina;
    }

    public String getTipoOrdenacao() {
        return tipoOrdenacao;
    }

    public void setTipoOrdenacao(String tipoOrdenacao) {
        this.tipoOrdenacao = tipoOrdenacao;
    }

    public String getOrdenarPor() {
        return ordenarPor;
    }

    public void setOrdenarPor(String ordenarPor) {
        this.ordenarPor = ordenarPor;
    }
}
