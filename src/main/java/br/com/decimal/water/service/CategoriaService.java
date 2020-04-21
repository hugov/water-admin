package br.com.decimal.water.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.decimal.water.entity.Categoria;

@PersistenceContext(name = "persistence/myStrutsJPA", unitName = "StrutsJPAPersistenceUnit", type = PersistenceContextType.EXTENDED)
public class CategoriaService implements Service<Integer, Categoria> {

	private static final Logger LOG = LogManager.getLogger(CategoriaService.class.getName());
	
	private EntityManagerFactory emf;
	private EntityManager em;

	public CategoriaService() {
		emf = Persistence.createEntityManagerFactory("water");
		em = emf.createEntityManager();
		
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
		LOG.info("Atualizando uma categoria");
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	@Override
	public void delete(Categoria entity) {
		LOG.info("Apagando uma categoria");
		em.remove(entity);
	}

}
