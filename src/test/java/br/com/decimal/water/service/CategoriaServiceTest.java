package br.com.decimal.water.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.decimal.water.entity.Categoria;

@TestMethodOrder(OrderAnnotation.class)
public class CategoriaServiceTest {
	
	private CategoriaService service;
	
	@BeforeEach
	public void prepareTest() {
		try {
			Files.copy(Paths.get("target/classes/META-INF/persistence.xml"),  // Origem
					Paths.get("target/test-classes/META-INF/persistence.xml"), // Destino
					StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.service = new CategoriaService();
	}
	
	@Test
	@Order(1)
	public void testCreateCatergoria() {
		Categoria c1 = new Categoria();
		c1.setDescricao("gás");
		c1.setSituacao(0);
		
		this.service.create(c1);
		
		assertEquals(1, this.service.list().size());
	}
	
	@Test
	@Order(2)
	public void testRetrieve() {
		Categoria entity = this.service.retrieve(1);
		assertNotNull(entity);
	}
	
	@Test
	@Order(3)
	public void testUpdate() {
		Categoria entity = this.service.retrieve(1);
		assertEquals("gás", entity.getDescricao());
		
		entity.setDescricao("Suporte de água");
		this.service.update(entity);
		
		entity = this.service.retrieve(1);
		assertEquals("Suporte de água", entity.getDescricao());
	}
	
	@Test
	@Order(4)
	public void testRemoveCatergoria() {
		this.service.delete(1);
		assertEquals(0, this.service.list().size());
	}
	
}
