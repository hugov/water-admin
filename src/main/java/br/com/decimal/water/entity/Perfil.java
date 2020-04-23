package br.com.decimal.water.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;

@Entity(name="Perfil")
public class Perfil implements Serializable {

	private static final long serialVersionUID = 684597420584646495L;

	private Integer id;
	private List<Funcionalidade> listaFuncionalidade;
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
