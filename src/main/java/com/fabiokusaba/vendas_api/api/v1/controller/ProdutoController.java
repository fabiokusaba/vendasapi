package com.fabiokusaba.vendas_api.api.v1.controller;

import com.fabiokusaba.vendas_api.api.v1.request.produto.cadastrar.CadastrarProdutoRequest;
import com.fabiokusaba.vendas_api.api.v1.response.produto.cadastrar.CadastrarProdutoResponse;
import com.fabiokusaba.vendas_api.domain.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<CadastrarProdutoResponse> cadastrar(@RequestBody CadastrarProdutoRequest request) {
        final var produto = produtoService.cadastrar(CadastrarProdutoRequest.toModel(request));
        return ResponseEntity.ok(CadastrarProdutoResponse.fromModel(produto));
    }
}
