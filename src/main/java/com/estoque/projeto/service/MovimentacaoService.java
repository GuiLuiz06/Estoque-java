package com.estoque.projeto.service;

import com.estoque.projeto.model.Movimentacao;
import com.estoque.projeto.model.Produto;
import com.estoque.projeto.repository.MovimentacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// Aplica as regras de negócio para entradas e saídas de estoque.
public class MovimentacaoService {

    private final MovimentacaoRepository repository;
    private final ProdutoService produtoService;

    public MovimentacaoService(MovimentacaoRepository repository, ProdutoService produtoService) {
        this.repository = repository;
        this.produtoService = produtoService;
    }

    public Movimentacao registrarEntrada(Long produtoId, int quantidade) {
        validarQuantidade(quantidade);

        Produto produto = produtoService.buscarPorId(produtoId);
        produto.adicionarEstoque(quantidade);

        return repository.salvar(
                new Movimentacao(null, produto, Movimentacao.Tipo.ENTRADA, quantidade)
        );
    }

    public Movimentacao registrarSaida(Long produtoId, int quantidade) {
        validarQuantidade(quantidade);

        Produto produto = produtoService.buscarPorId(produtoId);
        produto.removerEstoque(quantidade);

        return repository.salvar(
                new Movimentacao(null, produto, Movimentacao.Tipo.SAIDA, quantidade)
        );
    }

    public List<Movimentacao> listar() {
        return repository.listar();
    }

    public List<Movimentacao> listarPorProduto(Long produtoId) {
        produtoService.buscarPorId(produtoId);
        return repository.listarPorProduto(produtoId);
    }

    private void validarQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
    }
}