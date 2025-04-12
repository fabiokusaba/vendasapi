package com.fabiokusaba.vendas_api.domain.model;

import com.fabiokusaba.vendas_api.domain.model.enums.StatusVenda;
import com.fabiokusaba.vendas_api.domain.vo.ItemVenda;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document(collection = "venda")
public class Venda {

    @Id
    private String id;
    private String clienteId;
    private LocalDateTime data;
    private Double valor;
    private StatusVenda status;
    private List<ItemVenda> itens;

    private Venda(String clienteId, List<ItemVenda> itens) {
        this.id = UUID.randomUUID().toString();
        this.clienteId = clienteId;
        this.data = LocalDateTime.now();
        this.valor = 0.0;
        this.status = StatusVenda.ABERTA;
        this.itens = itens != null ? itens : new ArrayList<>();
    }

    public static Venda novaVenda(String clienteId, List<ItemVenda> itens) {
        return new Venda(clienteId, itens);
    }

    public void calcularValor() {
        this.valor = this.itens
                .stream()
                .mapToDouble(ItemVenda::getPrecoTotal)
                .sum();
    }

    public String getId() {
        return id;
    }

    public String getClienteId() {
        return clienteId;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Double getValor() {
        return valor;
    }

    public StatusVenda getStatus() {
        return status;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }
}
