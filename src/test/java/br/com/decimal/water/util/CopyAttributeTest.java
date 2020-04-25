package br.com.decimal.water.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.decimal.water.entity.Endereco;
import br.com.decimal.water.entity.Entregador;

public class CopyAttributeTest {
	
	private static final Logger LOG = LogManager.getLogger(CopyAttributeTest.class.getName());

	@Test
	public void testCopyValues() {
		
		Entregador entregadorOrigem = new Entregador();
		entregadorOrigem.setId(1);
		entregadorOrigem.setNome("Vitor Hugo Oliveira");
		entregadorOrigem.setEmail("hugov1983@gmail.com");
		entregadorOrigem.setCpf("223.658.838-00");
		entregadorOrigem.setSituacao(1);
		
		LOG.trace("Entregador Origem {}", entregadorOrigem);
		
		Endereco enderecoOrigem = new Endereco();
		enderecoOrigem.setId(1);
		enderecoOrigem.setLogradouro("Rua Serra de são domingos, 72");
		enderecoOrigem.setComplemento("BL 1 AP 63");
		enderecoOrigem.setCep("08290-370");
		enderecoOrigem.setBairro("Vila Carmosina");
		enderecoOrigem.setCidade("São Paulo");
		
		entregadorOrigem.setEndereco(enderecoOrigem);
		
		LOG.trace("Endereco Origem {}", enderecoOrigem);
		
		Entregador entregadorDestino = new Entregador();
		entregadorDestino.setId(14);
		LOG.trace("Entregador Destino {}", entregadorDestino);
		
		Endereco enderecoDestino = new Endereco();
		entregadorDestino.setEndereco(enderecoDestino);
		LOG.trace("Endereco Destino {}", enderecoDestino);
		
		try {
			
			Entregador entregadorFinal = (Entregador) ReflectionUtil.copyAttributesFromTo(entregadorDestino, entregadorOrigem);
			LOG.trace("Entregador Final {}", entregadorFinal);
			
			Assertions.assertEquals(entregadorFinal, entregadorOrigem);
			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
