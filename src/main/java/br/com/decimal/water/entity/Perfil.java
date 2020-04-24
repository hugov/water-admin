package br.com.decimal.water.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Perfil")
public class Perfil implements Serializable {

	private static final long serialVersionUID = 684597420584646495L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	
	private  transient List<Funcionalidade> listaFuncionalidade;
	private Integer situacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Funcionalidade> getListaFuncionalidade() {
		return listaFuncionalidade;
	}

	public void setListaFuncionalidade(List<Funcionalidade> listaFuncionalidade) {
		this.listaFuncionalidade = listaFuncionalidade;
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

}
