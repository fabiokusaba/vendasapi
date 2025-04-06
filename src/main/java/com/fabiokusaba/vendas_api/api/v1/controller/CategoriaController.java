package com.fabiokusaba.vendas_api.api.v1.controller;

import com.fabiokusaba.vendas_api.api.v1.request.categoria.cadastrar.CadastrarCategoriaRequest;
import com.fabiokusaba.vendas_api.api.v1.response.categoria.buscar.BuscarCategoriaResponse;
import com.fabiokusaba.vendas_api.api.v1.response.categoria.buscar.ListarCategoriaResponse;
import com.fabiokusaba.vendas_api.api.v1.response.categoria.cadastrar.CadastrarCategoriaResponse;
import com.fabiokusaba.vendas_api.domain.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<CadastrarCategoriaResponse> cadastrar(@RequestBody CadastrarCategoriaRequest request) {
        final var categoria = categoriaService.cadastrar(CadastrarCategoriaRequest.toModel(request));
        return ResponseEntity.ok(CadastrarCategoriaResponse.fromModel(categoria));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuscarCategoriaResponse> buscarPorId(@PathVariable("id") String id) {
        final var categoria = categoriaService.buscarPorId(id);
        return ResponseEntity.ok(BuscarCategoriaResponse.fromModel(categoria));
    }

    @GetMapping
    public ResponseEntity<List<ListarCategoriaResponse>> listar() {
        final var categorias = categoriaService.listar();
        return ResponseEntity.ok(ListarCategoriaResponse.fromModelList(categorias));
    }
}
