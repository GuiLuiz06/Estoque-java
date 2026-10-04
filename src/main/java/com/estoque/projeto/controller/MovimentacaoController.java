package com.estoque.projeto.controller;

import com.estoque.projeto.model.Movimentacao;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
// recebe as requisicoes http relacionadas às entradas e saidas
public class MovimentacaoController {

    private final MovimentacaoService service;

    public MovimentacaoController(MovimentacaoService service) {
        this.service = service;
    }

    @PostMapping("/entrada")
    @ResponseStatus(HttpStatus.CREATED)
    public Movimentacao entrada(Long produtoId, int quantidade) {
        return service.registrarEntrada(produtoId, quantidade);
    }

    @PostMapping("/saida")
    @ResponseStatus(HttpStatus.CREATED)
    public Movimentacao saida(Long produtoId, int quantidade) {
        return service.registrarSaida(produtoId, quantidade);
    }
}
