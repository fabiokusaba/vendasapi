package com.fabiokusaba.vendas_api.api.v1.openapi;

import com.fabiokusaba.vendas_api.api.v1.request.produto.atualizar.AtualizarProdutoRequest;
import com.fabiokusaba.vendas_api.api.v1.request.produto.cadastrar.CadastrarProdutoRequest;
import com.fabiokusaba.vendas_api.api.v1.response.produto.atualizar.AtualizarProdutoResponse;
import com.fabiokusaba.vendas_api.api.v1.response.produto.buscar.BuscarProdutoResponse;
import com.fabiokusaba.vendas_api.api.v1.response.produto.buscar.ListarProdutoResponse;
import com.fabiokusaba.vendas_api.api.v1.response.produto.cadastrar.CadastrarProdutoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Produtos", description = "Gerenciar produtos")
public interface ProdutoOpenAPI {

    @PostMapping
    @Operation(summary = "Cadastrar produto")
    @ApiResponse(responseCode = "201", description = "Produto cadastrado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno de servidor")
    ResponseEntity<CadastrarProdutoResponse> cadastrar(@RequestBody CadastrarProdutoRequest request);

    @GetMapping("/{id}")
    @Operation(summary = "Buscar um produto por ID")
    @ApiResponse(responseCode = "200", description = "Produto encontrado com sucesso")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno de servidor")
    ResponseEntity<BuscarProdutoResponse> buscarPorId(@PathVariable("id") String id);

    @GetMapping
    @Operation(summary = "Listar produtos")
    @ApiResponse(responseCode = "200", description = "Produtos listados com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro interno de servidor")
    ResponseEntity<List<ListarProdutoResponse>> listar(@RequestParam(required = false, defaultValue = "") String nome);

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar produto")
    @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno de servidor")
    ResponseEntity<AtualizarProdutoResponse> atualizar(@PathVariable("id") String id, @RequestBody AtualizarProdutoRequest request);

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um produto por ID")
    @ApiResponse(responseCode = "204", description = "Produto deletado com sucesso")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno de servidor")
    ResponseEntity<Void> deletarPorId(@PathVariable("id") String id);
}
