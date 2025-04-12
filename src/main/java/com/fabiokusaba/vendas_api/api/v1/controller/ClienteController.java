package com.fabiokusaba.vendas_api.api.v1.controller;

import com.fabiokusaba.vendas_api.api.v1.openapi.ClienteOpenAPI;
import com.fabiokusaba.vendas_api.api.v1.request.cliente.atualizar.AtualizarClienteRequest;
import com.fabiokusaba.vendas_api.api.v1.request.cliente.cadastrar.CadastrarClienteRequest;
import com.fabiokusaba.vendas_api.api.v1.response.cliente.atualizar.AtualizarClienteResponse;
import com.fabiokusaba.vendas_api.api.v1.response.cliente.buscar.BuscarClienteResponse;
import com.fabiokusaba.vendas_api.api.v1.response.cliente.buscar.ListarClienteResponse;
import com.fabiokusaba.vendas_api.api.v1.response.cliente.cadastrar.CadastrarClienteResponse;
import com.fabiokusaba.vendas_api.domain.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/clientes")
public class ClienteController implements ClienteOpenAPI {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public ResponseEntity<CadastrarClienteResponse> cadastrar(CadastrarClienteRequest request) {
        final var cliente = clienteService.cadastrar(CadastrarClienteRequest.toModel(request));
        return ResponseEntity.ok(CadastrarClienteResponse.fromModel(cliente));
    }

    public ResponseEntity<BuscarClienteResponse> buscarPorId(String id) {
        final var cliente = clienteService.buscarPorId(id);
        return ResponseEntity.ok(BuscarClienteResponse.fromModel(cliente));
    }

    public ResponseEntity<List<ListarClienteResponse>> listar(String nome) {
        final var clientes = clienteService.listar(nome);
        return ResponseEntity.ok(ListarClienteResponse.fromModelList(clientes));
    }

    public ResponseEntity<AtualizarClienteResponse> atualizar(String id, AtualizarClienteRequest request) {
        final var clienteAtualizado = clienteService.atualizar(id, AtualizarClienteRequest.toModel(request));
        return ResponseEntity.ok(AtualizarClienteResponse.fromModel(clienteAtualizado));
    }

    public ResponseEntity<Void> deletarPorId(String id) {
        clienteService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
