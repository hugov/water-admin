package br.com.decimal.water.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.decimal.water.entity.Categoria;

public class CategoriaServiceTest {
	
	private static final Logger LOG = LogManager.getLogger(CategoriaServiceTest.class.getName());
	
	private CategoriaService service;
	
	@Test
	public void testCreateCatergoria() {
		Categoria c1 = new Categoria();
		c1.setDescricao("gás");
		c1.setSituacao(0);
		
		this.service.create(c1);
		
		Assertions.assertEquals(2, this.service.list().size());
	}
	
	@Test
	public void testRemoveCatergoria() {
		Categoria c1 = new Categoria();
		c1.setId(1);
		
		this.service.delete(c1);
		
		Assertions.assertEquals(1, this.service.list().size());
	}
	
	@BeforeEach
	public void prepareTest() {
		
		this.service = new CategoriaService();
		
		LOG.info("Preparando os dados para o testes.");
		
		Categoria c1 = new Categoria();
		c1.setDescricao("água");
		c1.setSituacao(0);
		
		this.service.create(c1);
	}

}
