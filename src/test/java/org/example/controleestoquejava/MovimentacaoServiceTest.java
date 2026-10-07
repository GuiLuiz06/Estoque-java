package org.example.controleestoquejava;

import com.estoque.projeto.model.Categoria;
import com.estoque.projeto.model.Movimentacao;
import com.estoque.projeto.model.Produto;
import com.estoque.projeto.repository.CategoriaRepository;
import com.estoque.projeto.repository.MovimentacaoRepository;
import com.estoque.projeto.repository.ProdutoRepository;
import com.estoque.projeto.service.CategoriaService;
import com.estoque.projeto.service.MovimentacaoService;
import com.estoque.projeto.service.ProdutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovimentacaoServiceTest {

    private CategoriaService categoriaService;
    private ProdutoService produtoService;
    private MovimentacaoService movimentacaoService;

    @BeforeEach
    void configurar() {
        CategoriaRepository categoriaRepository = new CategoriaRepository();
        ProdutoRepository produtoRepository = new ProdutoRepository();
        MovimentacaoRepository movimentacaoRepository = new MovimentacaoRepository();

        categoriaService = new CategoriaService(categoriaRepository);
        produtoService = new ProdutoService(produtoRepository, categoriaService);
        movimentacaoService = new MovimentacaoService(
                movimentacaoRepository,
                produtoService
        );
    }

    private Produto criarProduto() {
        Categoria categoria = categoriaService.cadastrar(
                new Categoria(null, "Eletrônicos")
        );

        Produto produto = new Produto(
                null,
                "Teclado",
                100.0,
                5,
                categoria
        );

        return produtoService.cadastrar(produto, categoria.getId());
    }

    @Test
    void deveCadastrarProduto() {
        Produto produto = criarProduto();

        assertNotNull(produto.getId());
        assertEquals("Teclado", produto.getNome());
        assertEquals(0, produto.getEstoque());
    }

    @Test
    void deveRegistrarEntrada() {
        Produto produto = criarProduto();

        movimentacaoService.registrarEntrada(produto.getId(), 10);

        assertEquals(10, produto.getEstoque());
    }

    @Test
    void deveRegistrarSaida() {
        Produto produto = criarProduto();

        movimentacaoService.registrarEntrada(produto.getId(), 10);
        movimentacaoService.registrarSaida(produto.getId(), 4);

        assertEquals(6, produto.getEstoque());
    }

    @Test
    void naoDevePermitirSaidaMaiorQueEstoque() {
        Produto produto = criarProduto();

        movimentacaoService.registrarEntrada(produto.getId(), 5);

        assertThrows(
                IllegalStateException.class,
                () -> movimentacaoService.registrarSaida(produto.getId(), 6)
        );
    }

    @Test
    void naoDevePermitirQuantidadeMenorOuIgualAZero() {
        Produto produto = criarProduto();

        assertThrows(
                IllegalArgumentException.class,
                () -> movimentacaoService.registrarEntrada(produto.getId(), 0)
        );
    }

    @Test
    void naoDevePermitirProdutoInexistente() {
        assertThrows(
                IllegalArgumentException.class,
                () -> movimentacaoService.registrarEntrada(999L, 5)
        );
    }
}
