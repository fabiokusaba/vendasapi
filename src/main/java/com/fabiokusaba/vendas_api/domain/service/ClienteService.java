package com.fabiokusaba.vendas_api.domain.service;

import com.fabiokusaba.vendas_api.domain.model.Cliente;
import com.fabiokusaba.vendas_api.domain.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente cadastrar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente buscarPorId(String id) {
        return clienteRepository.findById(id).orElseThrow();
    }

    public List<Cliente> listar(String nome) {
        if (StringUtils.hasText(nome)) {
            return clienteRepository.findByNomeContainingIgnoreCase(nome);
        }
        return clienteRepository.findAll();
    }

    public Cliente atualizar(String id, Cliente cliente) {
        final var clienteSalvo = buscarPorId(id);
        clienteSalvo.atualizarCliente(cliente.getNome(), cliente.getCpf(), cliente.getEndereco());
        return clienteRepository.save(clienteSalvo);
    }

    public void deletarPorId(String id) {
        clienteRepository.deleteById(id);
    }
}
