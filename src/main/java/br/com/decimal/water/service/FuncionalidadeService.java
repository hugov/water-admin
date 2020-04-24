package br.com.decimal.water.service;

import java.util.List;
import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.decimal.water.entity.Funcionalidade;
import br.com.decimal.water.util.EntityManagerProvider;

public class FuncionalidadeService implements Service<Integer, Funcionalidade> {

	private static final Logger LOG = LogManager.getLogger(FuncionalidadeService.class.getName());
	
	private EntityManager em;

	public FuncionalidadeService() {
		EntityManagerProvider provider = EntityManagerProvider.getInstance();
		em = provider.createManager();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionalidade> list() {
		LOG.info("Listando os registros de funcionalidades cadastrados.");
		
		return em.createQuery("SELECT c FROM Funcionalidade c").getResultList();
	}

	@Override
	public void create(Funcionalidade entity) {
		LOG.info("Criando um registro de {} .", entity);
		
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	@Override
	public Funcionalidade retrieve(Integer id) {
		Funcionalidade categoria = em.find(Funcionalidade.class, id);
		LOG.info("O id {} pertence ao registro de {} .", id, categoria);

		return categoria;
	}

	@Override
	public void update(Funcionalidade entity) {
		LOG.info("Atualizando o registro de {} ", entity);
		
		Funcionalidade categoria = em.find(Funcionalidade.class, entity.getId());
		categoria.setDescricao(entity.getDescricao());
		categoria.setSituacao(entity.getSituacao());
		
		em.getTransaction().begin();
		em.persist(categoria);
		em.getTransaction().commit();
	}

	@Override
	public void delete(Integer id) {
		LOG.info("Apagando o registro de id {}", id);
		
		Funcionalidade funcionalidade = em.find(Funcionalidade.class, id);
		
		em.getTransaction().begin();
		em.remove(funcionalidade);
		em.getTransaction().commit();
	}

}
