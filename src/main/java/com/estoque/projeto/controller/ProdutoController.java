package com.estoque.projeto.controller;

import com.estoque.projeto.model.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto cadastrar(
            @RequestBody Produto produto,
            @RequestParam Long categoriaId) {
        return service.cadastrar(produto, categoriaId);
    }

    @GetMapping
    public List<Produto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/estoque-baixo")
    public List<Produto> listarEstoqueBaixo() {
        return service.listarEstoqueBaixo();
    }
}

