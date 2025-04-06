package com.fabiokusaba.vendas_api.api.v1.controller;

import com.fabiokusaba.vendas_api.api.v1.request.cliente.cadastrar.CadastrarClienteRequest;
import com.fabiokusaba.vendas_api.api.v1.response.cliente.buscar.BuscarClienteResponse;
import com.fabiokusaba.vendas_api.api.v1.response.cliente.cadastrar.CadastrarClienteResponse;
import com.fabiokusaba.vendas_api.domain.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<BuscarClienteResponse> buscarPorId(@PathVariable("id") String id) {
        final var cliente = clienteService.buscarPorId(id);
        return ResponseEntity.ok(BuscarClienteResponse.fromModel(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable("id") String id) {
        clienteService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
