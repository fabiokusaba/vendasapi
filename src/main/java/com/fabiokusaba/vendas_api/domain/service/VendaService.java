package com.fabiokusaba.vendas_api.domain.service;

import com.fabiokusaba.vendas_api.domain.model.Produto;
import com.fabiokusaba.vendas_api.domain.model.Venda;
import com.fabiokusaba.vendas_api.domain.repository.ClienteRepository;
import com.fabiokusaba.vendas_api.domain.repository.ProdutoRepository;
import com.fabiokusaba.vendas_api.domain.repository.VendaRepository;
import com.fabiokusaba.vendas_api.domain.vo.ItemVenda;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    public VendaService(VendaRepository vendaRepository,
                        ClienteRepository clienteRepository,
                        ProdutoRepository produtoRepository) {
        this.vendaRepository = vendaRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    public Venda cadastrar(Venda venda) {

        clienteRepository.findById(venda.getClienteId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        venda.agruparItens();

        final var produtos = produtoRepository.findAllById(venda.getItens()
                .stream()
                .map(ItemVenda::getProdutoId)
                .toList());

        final var totalDeProdutosInformados = venda.getItens().size();
        final var totalDeProdutosEncontrados = produtos.size();

        if (totalDeProdutosInformados != totalDeProdutosEncontrados) {
            throw new IllegalArgumentException("Um ou mais produtos não foram encontrados");
        }

        atualizarInformacoesItensVenda(venda, produtos);

        venda.calcularValor();

        return vendaRepository.save(venda);
    }

    public void adicionarItemVenda(String vendaId, ItemVenda itemVenda) {

        final var venda = vendaRepository.findById(vendaId)
                .orElseThrow(() -> new IllegalArgumentException("Venda não encontrada"));

        final var produto = produtoRepository.findById(itemVenda.getProdutoId())
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        adicionarItem(venda, itemVenda, produto);

        venda.calcularValor();

        vendaRepository.save(venda);
    }

    private void atualizarInformacoesItensVenda(Venda venda, List<Produto> produtos) {
        Map<String, Produto> produtosMap = produtos.stream()
                .collect(Collectors.toMap(Produto::getId, Function.identity()));

        venda.getItens().forEach(item -> {
            Produto produto = produtosMap.get(item.getProdutoId());

            item.setNome(produto.getNome());
            item.setPreco(produto.getPreco());
            item.setPrecoTotal(produto.getPreco() * item.getQuantidade());
        });
    }

    private void adicionarItem(Venda venda, ItemVenda itemVenda, Produto produto) {
        ItemVenda itemExistente = venda.getItens()
                .stream()
                .filter(item -> item.getProdutoId().equals(itemVenda.getProdutoId()))
                .findFirst()
                .orElse(null);

        if (itemExistente != null) {
            itemExistente.setQuantidade(itemExistente.getQuantidade() + itemVenda.getQuantidade());
            itemExistente.setPrecoTotal(itemExistente.getPrecoTotal() + (itemVenda.getQuantidade() * itemExistente.getPreco()));
        } else {
            itemVenda.setNome(produto.getNome());
            itemVenda.setPreco(produto.getPreco());
            itemVenda.setPrecoTotal(itemVenda.getQuantidade() * produto.getPreco());

            venda.getItens().add(itemVenda);
        }
    }
}
