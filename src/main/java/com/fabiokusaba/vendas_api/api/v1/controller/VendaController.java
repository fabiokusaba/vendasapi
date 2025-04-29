package com.fabiokusaba.vendas_api.api.v1.controller;

import com.fabiokusaba.vendas_api.api.v1.openapi.VendaOpenAPI;
import com.fabiokusaba.vendas_api.api.v1.request.venda.ItemVendaRequest;
import com.fabiokusaba.vendas_api.api.v1.request.venda.cadastrar.CadastrarVendaRequest;
import com.fabiokusaba.vendas_api.api.v1.response.venda.cadastrar.CadastrarVendaResponse;
import com.fabiokusaba.vendas_api.api.v1.response.venda.filter.VendaResponse;
import com.fabiokusaba.vendas_api.domain.filter.VendaFilter;
import com.fabiokusaba.vendas_api.domain.pagination.Pagination;
import com.fabiokusaba.vendas_api.domain.service.VendaQueryService;
import com.fabiokusaba.vendas_api.domain.service.VendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/vendas")
public class VendaController implements VendaOpenAPI {

    private final VendaService vendaService;
    private final VendaQueryService vendaQueryService;

    public VendaController(VendaService vendaService, VendaQueryService vendaQueryService) {
        this.vendaService = vendaService;
        this.vendaQueryService = vendaQueryService;
    }

    public ResponseEntity<CadastrarVendaResponse> cadastrar(CadastrarVendaRequest request) {
        final var venda = vendaService.cadastrar(CadastrarVendaRequest.toVenda(request));

        return ResponseEntity.status(HttpStatus.CREATED).body(new CadastrarVendaResponse(venda.getId()));
    }

    @Override
    public ResponseEntity<Void> adicionarItemVenda(String vendaId, ItemVendaRequest request) {
        vendaService.adicionarItemVenda(vendaId, ItemVendaRequest.toItemVenda(request));

        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> removerItemVenda(String vendaId, ItemVendaRequest request) {
        vendaService.removerItemVenda(vendaId, ItemVendaRequest.toItemVenda(request));

        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Pagination<VendaResponse>> listar(VendaFilter vendaFilter) {
        final var vendas = vendaQueryService.listar(vendaFilter);

        return ResponseEntity.ok().body(
                new Pagination<VendaResponse>(
                        vendas.pagina(),
                        vendas.qtdPorPagina(),
                        vendas.total(),
                        vendas.resultado().stream()
                                .map(VendaResponse::fromModel)
                                .toList()
                )
        );
    }
}
