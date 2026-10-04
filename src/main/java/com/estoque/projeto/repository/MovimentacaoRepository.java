package com.estoque.projeto.repository;

import org.springframework.stereotype.Repository;
import com.estoque.projeto.model.Movimentacao;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovimentacaoRepository {

    private final List<Movimentacao> movimentacoes = new ArrayList<>();
    private Long proximoID = 1L;

    public Movimentacao salvar(Movimentacao movimentacao) {
        Movimentacao novaMovimentacao = new Movimentacao(
                proximoID,
                movimentacao.getProduto(),
                movimentacao.getTipo(),
                movimentacao.getQuantidade()
        );
        proximoID++;
        movimentacoes.add(novaMovimentacao);
        return novaMovimentacao;
    }

    public List<Movimentacao> listar() {
       return new ArrayList<>(movimentacoes);}

    public List<Movimentacao> listarPorProduto(Long produtoID) {
        List<Movimentacao> resultado = new ArrayList<>();
        for (Movimentacao movimentacao : movimentacoes) {
            if (movimentacao.getProduto().getId().equals(produtoID)) {
                resultado.add(movimentacao);
            }
        }
        return resultado;
    }

}
