package br.com.decimal.water.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.decimal.water.entity.Endereco;
import br.com.decimal.water.entity.Entregador;
import br.com.decimal.water.util.EntityManagerProvider;

public class EntregadorService implements Service<Integer, Entregador> {

	private static final Logger LOG = LogManager.getLogger(EntregadorService.class.getName());
	
	private EntityManager em;

	public EntregadorService() {
		EntityManagerProvider provider = EntityManagerProvider.getInstance();
		em = provider.createManager();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Entregador> list() {
		LOG.info("Listando os registros de entregadores cadastrados.");
		
		return em.createQuery("SELECT c FROM Entregador c").getResultList();
	}

	@Override
	public void create(Entregador entity) {
		LOG.info("Criando um registro de {} .", entity);
		
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	@Override
	public Entregador retrieve(Integer id) {
		Entregador entregador = em.find(Entregador.class, id);
		LOG.info("O id {} pertence ao registro de {} .", id, entregador);

		return entregador;
	}

	@Override
	public void update(Entregador entity) {
		LOG.info("Atualizando o registro de {} ", entity);
		
		Entregador entregador = em.find(Entregador.class, entity.getId());

		entregador.setNome(entity.getNome());
		entregador.setCpf(entity.getCpf());
		entregador.setEmail(entity.getEmail());
		entregador.setSituacao(entity.getSituacao());

		Endereco endereco = entregador.getEndereco();
		Endereco enderecoEntity = entity.getEndereco();
		
		endereco.setCep(enderecoEntity.getCep());
		endereco.setLogradouro(enderecoEntity.getLogradouro());
		endereco.setComplemento(enderecoEntity.getComplemento());
		endereco.setBairro(enderecoEntity.getBairro());
		endereco.setCidade(enderecoEntity.getCidade());
		
		em.getTransaction().begin();
		em.persist(entregador);
		em.getTransaction().commit();
	}

	@Override
	public void delete(Integer id) {
		LOG.info("Apagando o registro de id {}", id);
		
		Entregador entregador = em.find(Entregador.class, id);
		
		em.getTransaction().begin();
		em.remove(entregador);
		em.getTransaction().commit();
	}

}
