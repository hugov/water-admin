package br.com.decimal.water.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity(name = "Catalogo")
public class Catalogo implements Serializable {

	private static final long serialVersionUID = 6776355355164834296L;

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
