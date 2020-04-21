package br.com.decimal.water.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.decimal.water.entity.Categoria;

public class CategoriaServiceTest {
	
	private CategoriaService service;
	
	@Test
	public void testCreateCatergoria() {
		Categoria c1 = new Categoria();
		c1.setDescricao("gás");
		c1.setSituacao(0);
		
		this.service.create(c1);
		
		assertEquals(2, this.service.list().size());
	}
	
	@Test
	public void testRemoveCatergoria() {
		Categoria c1 = new Categoria();
		c1.setId(1);
		
		this.service.delete(1);
		
		assertEquals(0, this.service.list().size());
	}
	
	@BeforeEach
	public void prepareTest() {
		
		this.service = new CategoriaService();
		
		Categoria c1 = new Categoria();
		c1.setDescricao("água");
		c1.setSituacao(0);
		
		this.service.create(c1);
	}

}
