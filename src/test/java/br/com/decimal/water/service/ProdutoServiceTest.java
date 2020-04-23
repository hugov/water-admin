package br.com.decimal.water.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import br.com.decimal.water.entity.Categoria;
import br.com.decimal.water.entity.Produto;

@TestMethodOrder(OrderAnnotation.class)
public class ProdutoServiceTest {

	private CategoriaService categoriaService;
	private ProdutoService produtoService;
	
	@BeforeEach
	public void prepareTest() {
		this.categoriaService = new CategoriaService();
		this.produtoService = new ProdutoService();
	}
	
	@Test
	@Order(1)
	public void testCreateCatergoria() {
		
		Categoria categoria = new Categoria();
		categoria.setDescricao("Agua");
		categoria.setSituacao(1);
		
		Produto produto1 = create(categoria, "Agua Bonafonte 350 ml", 1);
		Produto produto2 = create(categoria, "Agua Bonafonte 20 l", 1);
		Produto produto3 = create(categoria, "Agua Crystal 20 l", 1);
		
		this.produtoService.create(produto1);
		this.produtoService.create(produto2);
		this.produtoService.create(produto3);
		
		Assertions.assertNotNull(produto1);
		Assertions.assertNotNull(produto2);
		Assertions.assertNotNull(produto3);

		List<Categoria> categoriaList = this.categoriaService.list();
		for(Categoria c: categoriaList) {
			System.out.println(c);
		}
		
		List<Produto> produtoList = this.produtoService.list();
		for(Produto p : produtoList) {
			System.out.println(p);
		}
		
	}
	
	public Produto create(Categoria categoria, String descricao, int situacao) {
		Produto produto = new Produto();
		produto.setDescricao(descricao);
		produto.setSituacao(situacao);
		produto.setCategoriaId(categoria);
		
		return produto;
	}
	
}
