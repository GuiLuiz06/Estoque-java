package com.estoque.projeto.service;

import com.estoque.projeto.model.Categoria;
import com.estoque.projeto.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Contém as regras de negócio relacionadas às categorias.
@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public Categoria cadastrar(Categoria categoria) {
        if (categoria.getNome() == null || categoria.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome da categoria é obrigatório.");
        }
        return repository.salvar(categoria);
    }

    public List<Categoria> listar() {
        return repository.listar();
    }

    public Categoria buscarPorId(Long id) {
        Categoria categoria = repository.buscarPorId(id);
        if (categoria == null) {
            throw new IllegalArgumentException("Categoria não encontrada.");
        }
        return categoria;
    }
}