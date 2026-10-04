package com.estoque.projeto.controller;

import com.estoque.projeto.model.Categoria;
import com.estoque.projeto.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
// recebe as requisicoes http relacionadas as categorias
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria cadastrar(@RequestBody Categoria categoria) {
        return service.cadastrar(categoria);
    }
}
