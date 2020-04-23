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
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> list() {
		LOG.info("Listando os registros de categorias cadastrados.");
		
		return em.createQuery("SELECT c FROM Categoria c").getResultList();
	}

	@Override
	public void create(Categoria entity) {
		LOG.info("Criando um registro de {} .", entity);
		
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	@Override
	public Categoria retrieve(Integer id) {
		Categoria categoria = em.find(Categoria.class, id);
		LOG.info("O id {} pertence ao registro de {} .", id, categoria);

		return categoria;
	}

	@Override
	public void update(Categoria entity) {
		LOG.info("Atualizando o registro de {} ", entity);
		
		Categoria categoria = em.find(Categoria.class, entity.getId());
		categoria.setDescricao(entity.getDescricao());
		categoria.setSituacao(entity.getSituacao());
		
		em.getTransaction().begin();
		em.persist(categoria);
		em.getTransaction().commit();
	}

	@Override
	public void delete(Integer id) {
		LOG.info("Apagando o registro de categoria, com id {}", id);
		
		Categoria categoria = em.find(Categoria.class, id);
		
		em.getTransaction().begin();
		em.remove(categoria);
		em.getTransaction().commit();
	}

}
