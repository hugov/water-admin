package br.com.decimal.water.service;

import java.util.List;
import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.decimal.water.entity.Categoria;
import br.com.decimal.water.util.EntityManagerProvider;

public class CategoriaService implements Service<Integer, Categoria> {

	private static final Logger LOG = LogManager.getLogger(CategoriaService.class.getName());
	
	private EntityManager em;

	public CategoriaService() {
		EntityManagerProvider provider = EntityManagerProvider.getInstance();
		em = provider.createManager();
		
		LOG.warn( "EntityManager %b carregado com sucesso " , em != null );
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> list() {
		LOG.info("Listando os registro de categoria cadastrados.");
		
		return em.createQuery("SELECT c FROM Categoria c").getResultList();
	    
	}

	@Override
	public void create(Categoria entity) {
		LOG.info("Criando um registro de categoria.");
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	@Override
	public Categoria retrieve(Integer id) {
		LOG.info("Recuperando um registro de categoria.");
		return em.find(Categoria.class, id);
	}

	@Override
	public void update(Categoria entity) {
		LOG.info("Atualizando um registro de categoria");
		
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	@Override
	public void delete(Integer id) {
		LOG.info("Apagando um registro de categoria");
		
		Categoria categoria = em.find(Categoria.class, id);
		
		em.getTransaction().begin();
		em.remove(categoria);
		em.getTransaction().commit();
	}

}
