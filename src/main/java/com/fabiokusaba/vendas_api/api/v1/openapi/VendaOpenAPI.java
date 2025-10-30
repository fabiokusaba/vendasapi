package com.fabiokusaba.vendas_api.api.v1.openapi;

import com.fabiokusaba.vendas_api.api.v1.request.venda.ItemVendaRequest;
import com.fabiokusaba.vendas_api.api.v1.request.venda.cadastrar.CadastrarVendaRequest;
import com.fabiokusaba.vendas_api.api.v1.response.venda.cadastrar.CadastrarVendaResponse;
import com.fabiokusaba.vendas_api.api.v1.response.venda.filter.VendaResponse;
import com.fabiokusaba.vendas_api.domain.filter.VendaFilter;
import com.fabiokusaba.vendas_api.domain.pagination.Pagination;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Vendas", description = "Gerenciar vendas")
public interface VendaOpenAPI {

    @PostMapping
    @Operation(summary = "Cadastrar venda")
    @ApiResponse(responseCode = "201", description = "Venda cadastrada com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno de servidor")
    ResponseEntity<CadastrarVendaResponse> cadastrar(@RequestBody CadastrarVendaRequest request);

    @PostMapping("/{vendaId}/itens/adicionar")
    @Operation(summary = "Adicionar item na venda")
    @ApiResponse(responseCode = "204", description = "Item adicionado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno de servidor")
    ResponseEntity<Void> adicionarItemVenda(@PathVariable("vendaId") String vendaId, @RequestBody ItemVendaRequest request);

    @PostMapping("/{vendaId}/itens/remover")
    @Operation(summary = "Remover item na venda")
    @ApiResponse(responseCode = "204", description = "Item removido com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno de servidor")
    ResponseEntity<Void> removerItemVenda(@PathVariable("vendaId") String vendaId, @RequestBody ItemVendaRequest request);

    @GetMapping
    @Operation(summary = "Listar vendas com base nos parâmetros informados")
    @ApiResponse(responseCode = "200", description = "Vendas listadas com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno de servidor")
    ResponseEntity<Pagination<VendaResponse>> listar(@ModelAttribute VendaFilter vendaFilter);

    @GetMapping("/{id}")
    @Operation(summary = "Busca uma venda por id")
    @ApiResponse(responseCode = "200", description = "Venda buscada com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    ResponseEntity<VendaResponse> buscarPorId(@PathVariable("id") String id);

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove uma venda por id")
    @ApiResponse(responseCode = "204", description = "Venda removida com sucesso")
    @ApiResponse(responseCode = "404", description = "Venda não encontrada")
    @ApiResponse(responseCode = "500", description = "Erro interno de servidor")
    ResponseEntity<Void> deletarPorId(@PathVariable("id") String id);
}
