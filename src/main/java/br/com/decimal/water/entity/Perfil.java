package br.com.decimal.water.entity;

import java.io.Serializable;
import java.util.Set;

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
	private String descricao;
	
	//@OneToMany(mappedBy = "perfil")
    private Set<PerfilFuncionalidade> perfilFuncionalidade;
	
	private Integer situacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<PerfilFuncionalidade> getPerfilFuncionalidade() {
		return perfilFuncionalidade;
	}

	public void setPerfilFuncionalidade(Set<PerfilFuncionalidade> perfilFuncionalidade) {
		this.perfilFuncionalidade = perfilFuncionalidade;
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

}
