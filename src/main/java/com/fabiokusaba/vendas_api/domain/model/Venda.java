package com.fabiokusaba.vendas_api.domain.model;

import com.fabiokusaba.vendas_api.domain.model.enums.StatusVenda;
import com.fabiokusaba.vendas_api.domain.vo.ItemVenda;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

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
        this.itens = itens != null ? new ArrayList<>(itens) : new ArrayList<>();
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

    public void agruparItens() {
        Map<String, ItemVenda> itensAgrupados = this.itens
                .stream()
                .collect(Collectors.toMap(
                        ItemVenda::getProdutoId,
                        item -> ItemVenda.novoItemVenda(
                                item.getProdutoId(),
                                null,
                                null,
                                item.getQuantidade(),
                                null
                        ),
                        (item1, item2) -> {
                            item1.setQuantidade(item1.getQuantidade() + item2.getQuantidade());
                            return item1;
                        }
                ));

        this.itens.clear();
        this.itens.addAll(itensAgrupados.values());
    }

    public void adicionarItem(ItemVenda itemVenda) {
        this.itens.stream()
                .filter(item -> item.getProdutoId().equals(itemVenda.getProdutoId()))
                .findFirst()
                .ifPresentOrElse(
                        item -> {
                            item.setQuantidade(item.getQuantidade() + itemVenda.getQuantidade());
                            item.setPreco(itemVenda.getPreco());
                            item.setPrecoTotal(item.getQuantidade() * item.getPreco());
                        },
                        () -> this.itens.add(itemVenda)
                );

        this.calcularValor();
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
        return Collections.unmodifiableList(itens);
    }
}
