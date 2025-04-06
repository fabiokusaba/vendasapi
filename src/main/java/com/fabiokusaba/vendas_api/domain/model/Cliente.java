package com.fabiokusaba.vendas_api.domain.model;

import com.fabiokusaba.vendas_api.domain.vo.Endereco;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "cliente")
public class Cliente {

    @Id
    private String id;
    private String nome;
    private String cpf;
    private Endereco endereco;
    private Boolean ativo;

    private Cliente(String id, String nome, String cpf, Endereco endereco, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.ativo = ativo;
    }

    public static Cliente novoCliente(String nome, String cpf, Endereco endereco) {
        final var id = UUID.randomUUID().toString();
        return new Cliente(id, nome, cpf, endereco, true);
    }

    public Cliente atualizarCliente(String nome, String cpf, Endereco endereco) {
        if (endereco != null) {
            this.endereco = endereco;
        }
        if (cpf != null) {
            this.cpf = cpf;
        }
        this.nome = nome;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Boolean getAtivo() {
        return ativo;
    }
}
