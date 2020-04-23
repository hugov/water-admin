package br.com.decimal.water.service;

import java.util.List;
import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.decimal.water.entity.Produto;
import br.com.decimal.water.util.EntityManagerProvider;

public class ProdutoService implements Service<Integer, Produto> {

	private static final Logger LOG = LogManager.getLogger(ProdutoService.class.getName());
	
	private EntityManager em;

	public ProdutoService() {
		EntityManagerProvider provider = EntityManagerProvider.getInstance();
		em = provider.createManager();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> list() {
		LOG.info("Listando os registros de produtos cadastrados.");
		
		return em.createQuery("SELECT c FROM Produto c").getResultList();
	}

	@Override
	public void create(Produto entity) {
		LOG.info("Criando um registro de {} .", entity);
		
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	@Override
	public Produto retrieve(Integer id) {
		Produto produto = em.find(Produto.class, id);
		LOG.info("O id {} pertence ao registro de produto {} .", id, produto);

		return produto;
	}

	@Override
	public void update(Produto entity) {
		LOG.info("Atualizando o registro de {} ", entity);
		
		Produto produto = em.find(Produto.class, entity.getId());
		produto.setDescricao(entity.getDescricao());
		produto.setSituacao(entity.getSituacao());
		
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
	}

	@Override
	public void delete(Integer id) {
		LOG.info("Apagando o registro de produto, com id {}", id);
		
		Produto produto = em.find(Produto.class, id);
		
		em.getTransaction().begin();
		em.remove(produto);
		em.getTransaction().commit();
	}

}
