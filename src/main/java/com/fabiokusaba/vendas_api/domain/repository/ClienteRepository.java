package com.fabiokusaba.vendas_api.domain.repository;

import com.fabiokusaba.vendas_api.domain.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
}
