package com.fabiokusaba.vendas_api.domain.repository;

import com.fabiokusaba.vendas_api.domain.model.Categoria;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoriaRepository extends MongoRepository<Categoria, String> {
}
