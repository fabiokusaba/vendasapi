package com.fabiokusaba.vendas_api.api.v1.controller;

import com.fabiokusaba.vendas_api.api.v1.openapi.CategoriaOpenAPI;
import com.fabiokusaba.vendas_api.api.v1.request.categoria.atualizar.AtualizarCategoriaRequest;
import com.fabiokusaba.vendas_api.api.v1.request.categoria.cadastrar.CadastrarCategoriaRequest;
import com.fabiokusaba.vendas_api.api.v1.response.categoria.atualizar.AtualizarCategoriaResponse;
import com.fabiokusaba.vendas_api.api.v1.response.categoria.buscar.BuscarCategoriaResponse;
import com.fabiokusaba.vendas_api.api.v1.response.categoria.buscar.ListarCategoriaResponse;
import com.fabiokusaba.vendas_api.api.v1.response.categoria.cadastrar.CadastrarCategoriaResponse;
import com.fabiokusaba.vendas_api.domain.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/categorias")
public class CategoriaController implements CategoriaOpenAPI {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    public ResponseEntity<CadastrarCategoriaResponse> cadastrar(CadastrarCategoriaRequest request) {
        final var categoria = categoriaService.cadastrar(CadastrarCategoriaRequest.toModel(request));
        return ResponseEntity.ok(CadastrarCategoriaResponse.fromModel(categoria));
    }

    public ResponseEntity<BuscarCategoriaResponse> buscarPorId(String id) {
        final var categoria = categoriaService.buscarPorId(id);
        return ResponseEntity.ok(BuscarCategoriaResponse.fromModel(categoria));
    }

    public ResponseEntity<List<ListarCategoriaResponse>> listar() {
        final var categorias = categoriaService.listar();
        return ResponseEntity.ok(ListarCategoriaResponse.fromModelList(categorias));
    }

    public ResponseEntity<AtualizarCategoriaResponse> atualizar(String id, AtualizarCategoriaRequest request) {
        final var categoriaAtualizada = categoriaService.atualizar(id, AtualizarCategoriaRequest.toModel(request));
        return ResponseEntity.ok(AtualizarCategoriaResponse.fromModel(categoriaAtualizada));
    }

    public ResponseEntity<Void> deletarPorId(String id) {
        categoriaService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
