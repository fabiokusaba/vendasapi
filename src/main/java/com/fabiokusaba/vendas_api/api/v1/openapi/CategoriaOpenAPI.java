package com.fabiokusaba.vendas_api.api.v1.openapi;

import com.fabiokusaba.vendas_api.api.v1.request.categoria.atualizar.AtualizarCategoriaRequest;
import com.fabiokusaba.vendas_api.api.v1.request.categoria.cadastrar.CadastrarCategoriaRequest;
import com.fabiokusaba.vendas_api.api.v1.response.categoria.atualizar.AtualizarCategoriaResponse;
import com.fabiokusaba.vendas_api.api.v1.response.categoria.buscar.BuscarCategoriaResponse;
import com.fabiokusaba.vendas_api.api.v1.response.categoria.buscar.ListarCategoriaResponse;
import com.fabiokusaba.vendas_api.api.v1.response.categoria.cadastrar.CadastrarCategoriaResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Categorias", description = "Gerenciar categorias")
public interface CategoriaOpenAPI {

    @PostMapping
    @Operation(summary = "Cadastrar categoria")
    @ApiResponse(responseCode = "201", description = "Categoria cadastrada com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno de servidor")
    ResponseEntity<CadastrarCategoriaResponse> cadastrar(@RequestBody CadastrarCategoriaRequest request);

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar categoria")
    @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno de servidor")
    ResponseEntity<AtualizarCategoriaResponse> atualizar(@PathVariable("id") String id, @RequestBody AtualizarCategoriaRequest request);

    @GetMapping("/{id}")
    @Operation(summary = "Buscar uma categoria por ID")
    @ApiResponse(responseCode = "200", description = "Categoria encontrada com sucesso")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    @ApiResponse(responseCode = "500", description = "Erro interno de servidor")
    ResponseEntity<BuscarCategoriaResponse> buscarPorId(@PathVariable("id") String id);

    @GetMapping
    @Operation(summary = "Listar categorias")
    @ApiResponse(responseCode = "200", description = "Categorias listadas com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro interno de servidor")
    ResponseEntity<List<ListarCategoriaResponse>> listar();

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar uma categoria por ID")
    @ApiResponse(responseCode = "204", description = "Categoria deletada com sucesso")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    @ApiResponse(responseCode = "500", description = "Erro interno de servidor")
    ResponseEntity<Void> deletarPorId(@PathVariable("id") String id);
}
