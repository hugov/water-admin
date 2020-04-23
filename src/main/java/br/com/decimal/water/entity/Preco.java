package br.com.decimal.water.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity(name="Preco")
public class Preco implements Serializable {

	private static final long serialVersionUID = 5318575654662614044L;

	private Integer id;
	private Double valor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
