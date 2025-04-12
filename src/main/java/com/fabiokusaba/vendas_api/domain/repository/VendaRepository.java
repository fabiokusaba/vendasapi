package com.fabiokusaba.vendas_api.domain.repository;

import com.fabiokusaba.vendas_api.domain.model.Venda;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VendaRepository extends MongoRepository<Venda, String> {
}
