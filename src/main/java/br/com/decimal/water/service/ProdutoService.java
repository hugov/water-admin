package br.com.decimal.water.service;

import java.util.List;
import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.decimal.water.entity.Categoria;
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
		return em.createQuery("SELECT p FROM Produto p").getResultList();
	}

	@Override
	public void create(Produto entity) {
		LOG.info("Criando um registro de {} .", entity);
		
		Categoria categoria = em.find(Categoria.class, entity.getCategoria().getId());
		entity.setCategoria(categoria);
		
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	@Override
	public Produto retrieve(Integer id) {
		Produto produto = em.find(Produto.class, id);
		LOG.info("O id {} pertence ao registro de {} .", id, produto);

		return produto;
	}

	@Override
	public void update(Produto entity) {
		LOG.info("Atualizando o registro de {} ", entity);
		
		Produto produto = em.find(Produto.class, entity.getId());
		produto.setNome(entity.getNome());
		produto.setPreco(entity.getPreco());
		
		Categoria categoria = em.find(Categoria.class, entity.getCategoria().getId());

		produto.setCategoria(categoria);
		produto.setSituacao(entity.getSituacao());
		
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
	}

	@Override
	public void delete(Integer id) {
		LOG.info("Apagando o registro de id {}", id);
		
		Produto produto = em.find(Produto.class, id);
		
		em.getTransaction().begin();
		em.remove(produto);
		em.getTransaction().commit();
	}

}
