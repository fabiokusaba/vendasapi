package com.fabiokusaba.vendas_api.api.v1.openapi;

import com.fabiokusaba.vendas_api.api.v1.request.cliente.atualizar.AtualizarClienteRequest;
import com.fabiokusaba.vendas_api.api.v1.request.cliente.cadastrar.CadastrarClienteRequest;
import com.fabiokusaba.vendas_api.api.v1.response.cliente.atualizar.AtualizarClienteResponse;
import com.fabiokusaba.vendas_api.api.v1.response.cliente.buscar.BuscarClienteResponse;
import com.fabiokusaba.vendas_api.api.v1.response.cliente.buscar.ListarClienteResponse;
import com.fabiokusaba.vendas_api.api.v1.response.cliente.cadastrar.CadastrarClienteResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Clientes", description = "Gerenciar clientes")
public interface ClienteOpenAPI {

    @PostMapping
    @Operation(summary = "Cadastrar cliente")
    @ApiResponse(responseCode = "201", description = "Cliente cadastrado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno de servidor")
    ResponseEntity<CadastrarClienteResponse> cadastrar(@RequestBody CadastrarClienteRequest request);

    @GetMapping("/{id}")
    @Operation(summary = "Buscar um cliente por ID")
    @ApiResponse(responseCode = "200", description = "Cliente encontrado com sucesso")
    @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno de servidor")
    ResponseEntity<BuscarClienteResponse> buscarPorId(@PathVariable("id") String id);

    @GetMapping
    @Operation(summary = "Listar clientes")
    @ApiResponse(responseCode = "200", description = "Clientes listados com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro interno de servidor")
    ResponseEntity<List<ListarClienteResponse>> listar(@RequestParam(required = false, defaultValue = "") String nome);

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar cliente")
    @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno de servidor")
    ResponseEntity<AtualizarClienteResponse> atualizar(@PathVariable("id") String id, @RequestBody AtualizarClienteRequest request);

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um cliente por ID")
    @ApiResponse(responseCode = "204", description = "Cliente deletado com sucesso")
    @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno de servidor")
    ResponseEntity<Void> deletarPorId(@PathVariable("id") String id);
}
