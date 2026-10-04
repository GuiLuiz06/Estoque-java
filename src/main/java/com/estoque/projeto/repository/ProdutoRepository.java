package com.estoque.projeto.repository;

import com.estoque.projeto.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// Guarda os produtos em memória; os dados são apagados ao reiniciar a aplicação.
@Repository
public class ProdutoRepository {

    private final List<Produto> produtos = new ArrayList<>();
    private Long proximoId = 1L;

    public Produto salvar(Produto produto) {
        produto.setId(proximoId);
        proximoId++;
        produtos.add(produto);
        return produto;
    }

    public List<Produto> listar() {
        return new ArrayList<>(produtos);
    }

    public Produto buscarPorId(Long id) {
        for (Produto produto : produtos) {
            if (produto.getId().equals(id)) {
                return produto;
            }
        }
        return null;
    }
}