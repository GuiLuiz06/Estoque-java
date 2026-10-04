package com.estoque.projeto.repository;

import com.estoque.projeto.model.Categoria;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoriaRepository {

    private final List<Categoria> categorias = new ArrayList<>();
    private Long proximoID = 1L;

    public Categoria salvar(Categoria categoria) {
        categoria.setId(proximoID);
        proximoID++;
        categorias.add(categoria);
        return categoria;
    }

    public List<Categoria> listar() { return new ArrayList<>(categorias); }

    public Categoria buscarPorId(Long id) {
        for (Categoria categoria : categorias) {
            if (categoria.getId().equals(id)) {
                return categoria;
            }
        }
        return null;
    }
}
