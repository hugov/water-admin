package br.com.decimal.water.service;

import java.util.List;

public interface Service<PK, Entity> {

	List<Entity> list();
	
	void create(Entity entity);

	Entity retrieve(PK id);
	
	void update(Entity entity);
	
	void delete(PK id);
	
}
