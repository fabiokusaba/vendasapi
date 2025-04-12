package com.fabiokusaba.vendas_api.api.v1.controller;

import com.fabiokusaba.vendas_api.api.v1.request.venda.cadastrar.CadastrarVendaRequest;
import com.fabiokusaba.vendas_api.api.v1.response.venda.cadastrar.CadastrarVendaResponse;
import com.fabiokusaba.vendas_api.domain.service.VendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/vendas")
public class VendaController {

    private final VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @PostMapping
    public ResponseEntity<CadastrarVendaResponse> cadastrar(@RequestBody CadastrarVendaRequest request) {
        final var venda = vendaService.cadastrar(CadastrarVendaRequest.toVenda(request));

        return ResponseEntity.status(HttpStatus.CREATED).body(new CadastrarVendaResponse(venda.getId()));
    }
}
