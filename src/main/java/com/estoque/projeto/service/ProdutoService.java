package com.estoque.projeto.service;

import com.estoque.projeto.model.Categoria;
import com.estoque.projeto.model.Produto;
import com.estoque.projeto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// Contém as regras de negócio relacionadas aos produtos.
@Service
public class ProdutoService {

    private final ProdutoRepository repository;
    private final CategoriaService categoriaService;

    public ProdutoService(ProdutoRepository repository, CategoriaService categoriaService) {
        this.repository = repository;
        this.categoriaService = categoriaService;
    }

    public Produto cadastrar(Produto produto, Long categoriaId) {
        if (produto.getNome() == null || produto.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome do produto é obrigatório.");
        }
        if (produto.getPreco() <= 0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero.");
        }
        if (produto.getEstoqueMinimo() < 0) {
            throw new IllegalArgumentException("O estoque mínimo não pode ser negativo.");
        }

        Categoria categoria = categoriaService.buscarPorId(categoriaId);
        produto.setCategoria(categoria);
        produto.setEstoque(0);
        return repository.salvar(produto);
    }

    public List<Produto> listar() {
        return repository.listar();
    }

    public Produto buscarPorId(Long id) {
        Produto produto = repository.buscarPorId(id);
        if (produto == null) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }
        return produto;
    }

    public List<Produto> listarEstoqueBaixo() {
        List<Produto> produtosComEstoqueBaixo = new ArrayList<>();
        for (Produto produto : repository.listar()) {
            if (produto.estaAbaixoDoEstoqueMinimo()) {
                produtosComEstoqueBaixo.add(produto);
            }
        }
        return produtosComEstoqueBaixo;
    }
}