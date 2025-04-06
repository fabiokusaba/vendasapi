package com.fabiokusaba.vendas_api.domain.repository;

import com.fabiokusaba.vendas_api.domain.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProdutoRepository extends MongoRepository<Produto, String> {

    List<Produto> findByNomeContainingIgnoreCase(String nome);
}
