package br.com.decimal.water.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import br.com.decimal.water.entity.Categoria;
import br.com.decimal.water.entity.Funcionalidade;
import br.com.decimal.water.entity.Perfil;
import br.com.decimal.water.entity.PerfilFuncionalidade;
import br.com.decimal.water.entity.Produto;

@TestMethodOrder(OrderAnnotation.class)
public class PerfilServiceTest {
	
	private PerfilService perfilService;
	private FuncionalidadeService funcionalidadeService;
	
	@BeforeEach
	public void prepareTest() {
		this.perfilService = new PerfilService();
		this.funcionalidadeService = new FuncionalidadeService();
	}
	
	@Test
	@Order(1)
	public void testCreateCatergoria() {
		
		Funcionalidade f1 = new Funcionalidade();
		f1.setDescricao("Funcionalidade 1");
		f1.setSituacao(1);
		
		Funcionalidade f2 = new Funcionalidade();
		f2.setDescricao("Funcionalidade 1");
		f2.setSituacao(1);
		
		Funcionalidade f3 = new Funcionalidade();
		f3.setDescricao("Funcionalidade 1");
		f3.setSituacao(1);
		
		funcionalidadeService.create(f1);
		funcionalidadeService.create(f2);
		funcionalidadeService.create(f3);
		
		Perfil p1 = new Perfil();
		p1.setDescricao("Perfil 1");
		p1.setSituacao(1);

		Perfil p2 = new Perfil();
		p2.setDescricao("Perfil 2");
		p2.setSituacao(1);
		
		PerfilFuncionalidade pf1 = new PerfilFuncionalidade();
		pf1.setPerfil(p1);
		pf1.setFuncionalidade(f1);
		
		PerfilFuncionalidade pf2 = new PerfilFuncionalidade();
		pf2.setPerfil(p1);
		pf2.setFuncionalidade(f3);
		
		Set<PerfilFuncionalidade> set = new HashSet<PerfilFuncionalidade>();
		set.add(pf1);
		set.add(pf2);
	
		p1.setPerfilFuncionalidade(set);
		
		p2.setPerfilFuncionalidade(set);
		
		perfilService.create(p1);
		perfilService.create(p2);
		
		
		
		
	}

}
