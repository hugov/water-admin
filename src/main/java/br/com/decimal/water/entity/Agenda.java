package br.com.decimal.water.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Agenda")
public class Agenda implements Serializable {

	private static final long serialVersionUID = 5260449014560304501L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	private Date vigenciaInicial;
	private Date vigenciaFinal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getVigenciaInicial() {
		return (Date) vigenciaInicial.clone();
	}

	public void setVigenciaInicial(Date vigenciaInicial) {
		this.vigenciaInicial = (Date) vigenciaInicial.clone();
	}

	public Date getVigenciaFinal() {
		return (Date) vigenciaFinal.clone();
	}

	public void setVigenciaFinal(Date vigenciaFinal) {
		this.vigenciaFinal = (Date) vigenciaFinal.clone();
	}

}
