package com.fabiokusaba.vendas_api.api.v1.controller;

import com.fabiokusaba.vendas_api.api.v1.openapi.ProdutoOpenAPI;
import com.fabiokusaba.vendas_api.api.v1.request.produto.atualizar.AtualizarProdutoRequest;
import com.fabiokusaba.vendas_api.api.v1.request.produto.cadastrar.CadastrarProdutoRequest;
import com.fabiokusaba.vendas_api.api.v1.response.produto.atualizar.AtualizarProdutoResponse;
import com.fabiokusaba.vendas_api.api.v1.response.produto.buscar.BuscarProdutoResponse;
import com.fabiokusaba.vendas_api.api.v1.response.produto.buscar.ListarProdutoResponse;
import com.fabiokusaba.vendas_api.api.v1.response.produto.cadastrar.CadastrarProdutoResponse;
import com.fabiokusaba.vendas_api.domain.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
public class ProdutoController implements ProdutoOpenAPI {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public ResponseEntity<CadastrarProdutoResponse> cadastrar(CadastrarProdutoRequest request) {
        final var produto = produtoService.cadastrar(CadastrarProdutoRequest.toModel(request));
        return ResponseEntity.ok(CadastrarProdutoResponse.fromModel(produto));
    }

    public ResponseEntity<BuscarProdutoResponse> buscarPorId(String id) {
        final var produto = produtoService.buscarPorId(id);
        return ResponseEntity.ok(BuscarProdutoResponse.fromModel(produto));
    }

    public ResponseEntity<List<ListarProdutoResponse>> listar(String nome) {
        final var produtos = produtoService.listar(nome);
        return ResponseEntity.ok(ListarProdutoResponse.fromModelList(produtos));
    }

    public ResponseEntity<AtualizarProdutoResponse> atualizar(String id, AtualizarProdutoRequest request) {
        final var produto = produtoService.atualizar(id, AtualizarProdutoRequest.toModel(request));
        return ResponseEntity.ok(AtualizarProdutoResponse.fromModel(produto));
    }

    public ResponseEntity<Void> deletarPorId(String id) {
        produtoService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
