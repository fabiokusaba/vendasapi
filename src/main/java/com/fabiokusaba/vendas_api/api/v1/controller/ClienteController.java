package com.fabiokusaba.vendas_api.api.v1.controller;

import com.fabiokusaba.vendas_api.api.v1.request.CadastrarClienteRequest;
import com.fabiokusaba.vendas_api.api.v1.response.CadastrarClienteResponse;
import com.fabiokusaba.vendas_api.domain.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<CadastrarClienteResponse> cadastrar(@RequestBody CadastrarClienteRequest request) {
        final var cliente = clienteService.cadastrar(CadastrarClienteRequest.toModel(request));
        return ResponseEntity.ok(CadastrarClienteResponse.fromModel(cliente));
    }
}
