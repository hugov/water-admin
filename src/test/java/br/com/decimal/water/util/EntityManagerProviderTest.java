package br.com.decimal.water.util;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.jupiter.api.Test;

public class EntityManagerProviderTest {
	
	@Test
	public void testSingletonFactory() {
		
		EntityManagerProvider provider = EntityManagerProvider.getInstance();
		
		EntityManagerFactory factory = provider.getFactory();
		assertEquals(factory, provider.getFactory());
		assertEquals(factory, provider.getFactory());
		
		EntityManager entityManager = provider.createManager();
		assertNotEquals(entityManager, provider.createManager());
		assertNotEquals(entityManager, provider.createManager());
		
	}

}
