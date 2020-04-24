package br.com.decimal.water.service;

import java.util.List;
import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.decimal.water.entity.Perfil;
import br.com.decimal.water.util.EntityManagerProvider;

public class PerfilService implements Service<Integer, Perfil> {

	private static final Logger LOG = LogManager.getLogger(PerfilService.class.getName());
	
	private EntityManager em;

	public PerfilService() {
		EntityManagerProvider provider = EntityManagerProvider.getInstance();
		em = provider.createManager();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Perfil> list() {
		LOG.info("Listando os registros de perfis cadastrados.");
		
		return em.createQuery("SELECT c FROM Perfil c").getResultList();
	}

	@Override
	public void create(Perfil entity) {
		LOG.info("Criando um registro de {} .", entity);
		
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	@Override
	public Perfil retrieve(Integer id) {
		Perfil categoria = em.find(Perfil.class, id);
		LOG.info("O id {} pertence ao registro de {} .", id, categoria);

		return categoria;
	}

	@Override
	public void update(Perfil entity) {
		LOG.info("Atualizando o registro de {} ", entity);
		
		Perfil perfil = em.find(Perfil.class, entity.getId());

		//FIXME: Copiar os valores para outro objeto
		//entregador.setDescricao(entity.getDescricao());
		//entregador.setSituacao(entity.getSituacao());
		
		em.getTransaction().begin();
		em.persist(perfil);
		em.getTransaction().commit();
	}

	@Override
	public void delete(Integer id) {
		LOG.info("Apagando o registro de id {}", id);
		
		Perfil perfil = em.find(Perfil.class, id);
		
		em.getTransaction().begin();
		em.remove(perfil);
		em.getTransaction().commit();
	}

}
