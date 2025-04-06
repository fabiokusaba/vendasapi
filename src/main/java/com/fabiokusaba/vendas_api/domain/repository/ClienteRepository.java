package com.fabiokusaba.vendas_api.domain.repository;

import com.fabiokusaba.vendas_api.domain.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

    @Query("{'nome': {$regex:  ?0, $options:  'i'}}")
    List<Cliente> buscarPorNome(String nome);

    List<Cliente> findByNomeContainingIgnoreCase(String nome);
}
