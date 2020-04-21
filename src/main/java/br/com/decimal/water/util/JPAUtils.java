package br.com.decimal.water.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {

	private static EntityManagerFactory factory;

	public static EntityManagerFactory getFactory() {
		if (factory == null || !factory.isOpen()) {
			factory = Persistence.createEntityManagerFactory("water");
		}
		
		return factory;
	}

	public static EntityManager getEntityManager() {
		return getFactory().createEntityManager();
	}

}
