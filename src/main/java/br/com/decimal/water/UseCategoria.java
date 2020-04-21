package br.com.decimal.water;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.decimal.water.entity.Categoria;

public class UseCategoria {

	public static void main(String [] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("water");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Código CRUD aqui
		
		Categoria categoria = new Categoria();
		categoria.setDescricao("Água");
		categoria.setSituacao(0);
	
		entityManager.persist(categoria);
		System.out.println(categoria);
		
		categoria = new Categoria();
		categoria.setDescricao("Água");
		categoria.setSituacao(0);
	
		entityManager.persist(categoria);
		System.out.println(categoria);

		entityManager.close();
		entityManagerFactory.close();
	}

}
