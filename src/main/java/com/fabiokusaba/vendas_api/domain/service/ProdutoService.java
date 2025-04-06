package com.fabiokusaba.vendas_api.domain.service;

import com.fabiokusaba.vendas_api.domain.model.Categoria;
import com.fabiokusaba.vendas_api.domain.model.Produto;
import com.fabiokusaba.vendas_api.domain.repository.CategoriaRepository;
import com.fabiokusaba.vendas_api.domain.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public Produto cadastrar(Produto produto) {
        if (produto.getCategorias() != null && !produto.getCategorias().isEmpty()) {
            var categorias = categoriaRepository.findAllById(produto.getCategorias());
            if (categorias.size() != produto.getCategorias().size()) {
                throw new IllegalArgumentException("Algumas categorias não foram encontradas");
            }
        }
        return produtoRepository.save(produto);
    }

    public Produto buscarPorId(String id) {
        return produtoRepository.findById(id).orElseThrow();
    }

    public List<Produto> listar(String nome) {
        if (StringUtils.hasText(nome)) {
            return produtoRepository.findByNomeContainingIgnoreCase(nome);
        }
        return produtoRepository.findAll();
    }
}
