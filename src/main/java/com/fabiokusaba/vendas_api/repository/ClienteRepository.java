package com.fabiokusaba.vendas_api.repository;

import com.fabiokusaba.vendas_api.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
}
