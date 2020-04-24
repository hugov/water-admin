package br.com.decimal.water.service;

import java.util.List;
import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.decimal.water.entity.Preco;
import br.com.decimal.water.util.EntityManagerProvider;

public class PrecoService implements Service<Integer, Preco> {

	private static final Logger LOG = LogManager.getLogger(PrecoService.class.getName());
	
	private EntityManager em;

	public PrecoService() {
		EntityManagerProvider provider = EntityManagerProvider.getInstance();
		em = provider.createManager();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Preco> list() {
		LOG.info("Listando os registros de preços cadastrados.");
		
		return em.createQuery("SELECT c FROM Preco c").getResultList();
	}

	@Override
	public void create(Preco entity) {
		LOG.info("Criando um registro de {} .", entity);
		
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	@Override
	public Preco retrieve(Integer id) {
		Preco preco = em.find(Preco.class, id);
		LOG.info("O id {} pertence ao registro de {} .", id, preco);

		return preco;
	}

	@Override
	public void update(Preco entity) {
		LOG.info("Atualizando o registro de {} ", entity);
		
		Preco preco = em.find(Preco.class, entity.getId());
		//FIXME: Corrigir
		//categoria.setDescricao(entity.getDescricao());
		//categoria.setSituacao(entity.getSituacao());
		
		em.getTransaction().begin();
		em.persist(preco);
		em.getTransaction().commit();
	}

	@Override
	public void delete(Integer id) {
		LOG.info("Apagando o registro de id {}", id);
		
		Preco preco = em.find(Preco.class, id);
		
		em.getTransaction().begin();
		em.remove(preco);
		em.getTransaction().commit();
	}

}
