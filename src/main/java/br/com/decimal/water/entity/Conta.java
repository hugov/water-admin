package br.com.decimal.water.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity(name="Conta")
public class Conta implements Serializable {

	private static final long serialVersionUID = -1396502373205223929L;

	private Integer id;
	private String nome;
	private String usuario;
	private String senha;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
