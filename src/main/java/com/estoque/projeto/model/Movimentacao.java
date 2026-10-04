package com.estoque.projeto.model;

import java.time.LocalDateTime;

// Representa uma entrada ou saída de estoque.
public class Movimentacao {

    public enum Tipo {
        ENTRADA,
        SAIDA
    }

    private Long id;
    private Produto produto;
    private Tipo tipo;
    private int quantidade;
    private LocalDateTime data;

    public Movimentacao() {
    }

    public Movimentacao(Long id, Produto produto, Tipo tipo, int quantidade, LocalDateTime data) {
        this.id = id;
        this.produto = produto;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public LocalDateTime getData() {
        return data;
    }
}
