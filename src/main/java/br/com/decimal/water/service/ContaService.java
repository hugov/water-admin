package br.com.decimal.water.service;

import java.util.List;
import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.decimal.water.entity.Conta;
import br.com.decimal.water.util.EntityManagerProvider;

public class ContaService implements Service<Integer, Conta> {

	private static final Logger LOG = LogManager.getLogger(ContaService.class.getName());
	
	private EntityManager em;

	public ContaService() {
		EntityManagerProvider provider = EntityManagerProvider.getInstance();
		em = provider.createManager();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Conta> list() {
		LOG.info("Listando os registros de contas cadastrados.");
		
		return em.createQuery("SELECT c FROM Conta c").getResultList();
	}

	@Override
	public void create(Conta entity) {
		LOG.info("Criando um registro de {} .", entity);
		
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	@Override
	public Conta retrieve(Integer id) {
		Conta categoria = em.find(Conta.class, id);
		LOG.info("O id {} pertence ao registro de {} .", id, categoria);

		return categoria;
	}

	@Override
	public void update(Conta entity) {
		LOG.info("Atualizando o registro de {} ", entity);
		
		Conta conta = em.find(Conta.class, entity.getId());
		//FIXME: Corrigir
		//categoria.setDescricao(entity.getDescricao());
		//categoria.setSituacao(entity.getSituacao());
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
	}

	@Override
	public void delete(Integer id) {
		LOG.info("Apagando o registro de id {}", id);
		
		Conta conta = em.find(Conta.class, id);
		
		em.getTransaction().begin();
		em.remove(conta);
		em.getTransaction().commit();
	}

}
