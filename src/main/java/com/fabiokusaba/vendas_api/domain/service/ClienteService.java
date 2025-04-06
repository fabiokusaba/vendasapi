package com.fabiokusaba.vendas_api.domain.service;

import com.fabiokusaba.vendas_api.domain.model.Cliente;
import com.fabiokusaba.vendas_api.domain.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente cadastrar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
