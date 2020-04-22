package br.com.decimal.water.util;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class EntityManagerProviderTest {
	
	private static final Logger LOG = LogManager.getLogger(EntityManagerProviderTest.class.getName());
	
	@Test
	public void testSingletonFactory() {
		
		LOG.info("Executando o teste testSingletonFactory");
		
		EntityManagerProvider provider = EntityManagerProvider.getInstance();
		
		EntityManagerFactory factory = provider.getFactory();
		assertEquals(factory, provider.getFactory());
		assertEquals(factory, provider.getFactory());
		
		EntityManager entityManager = provider.createManager();
		assertNotEquals(entityManager, provider.createManager());
		assertNotEquals(entityManager, provider.createManager());
		
	}

}
