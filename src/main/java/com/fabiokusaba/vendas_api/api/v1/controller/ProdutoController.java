package com.fabiokusaba.vendas_api.api.v1.controller;

import com.fabiokusaba.vendas_api.api.v1.request.produto.cadastrar.CadastrarProdutoRequest;
import com.fabiokusaba.vendas_api.api.v1.response.produto.buscar.BuscarProdutoResponse;
import com.fabiokusaba.vendas_api.api.v1.response.produto.buscar.ListarProdutoResponse;
import com.fabiokusaba.vendas_api.api.v1.response.produto.cadastrar.CadastrarProdutoResponse;
import com.fabiokusaba.vendas_api.domain.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<BuscarProdutoResponse> buscarPorId(@PathVariable("id") String id) {
        final var produto = produtoService.buscarPorId(id);
        return ResponseEntity.ok(BuscarProdutoResponse.fromModel(produto));
    }

    @GetMapping
    public ResponseEntity<List<ListarProdutoResponse>> listar(@RequestParam(required = false, defaultValue = "") String nome) {
        final var produtos = produtoService.listar(nome);
        return ResponseEntity.ok(ListarProdutoResponse.fromModelList(produtos));
    }
}
