package br.com.decimal.water.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoriaTest {

	@Test
	public void testEquals() {
		
		Categoria c1 = new Categoria();
		c1.setId(1);
		
		Categoria c2 = new Categoria();
		c2.setId(1);
		
		Categoria c3 = new Categoria();
		c3.setId(2);
		
		Assertions.assertTrue(c1.equals(c2));
		Assertions.assertEquals(c1, c2);
		
		Assertions.assertFalse(c1.equals(c3));
		Assertions.assertNotEquals(c1, c3);
		
	}
	
}
