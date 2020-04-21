package br.com.decimal.water.service;

import java.util.List;

public interface Service<PK, Entity> {

	public List<Entity> list();
	
	public void create(Entity entity);

	public Entity retrieve(PK id);
	
	public void update(Entity entity);
	
	public void delete(Entity entity);
	
}
