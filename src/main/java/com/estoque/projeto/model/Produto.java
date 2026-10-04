package com.estoque.projeto.model;

// Representa um produto e contém operações básicas sobre seu estoque.
public class Produto {

    private Long id;
    private String nome;
    private double preco;
    private int estoque;
    private int estoqueMinimo;
    private Categoria categoria;

    public Produto() {
    }

    public Produto(Long id, String nome, double preco, int estoqueMinimo, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoqueMinimo = estoqueMinimo;
        this.categoria = categoria;
        this.estoque = 0;
    }

    public void adicionarEstoque(int quantidade) {
        estoque += quantidade;
    }

    public void removerEstoque(int quantidade) {
        if (quantidade > estoque) {
            throw new IllegalStateException("Estoque insuficiente.");
        }
        estoque -= quantidade;
    }

    public boolean estaAbaixoDoEstoqueMinimo() {
        return estoque <= estoqueMinimo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}