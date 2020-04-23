package br.com.decimal.water.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity(name="Entregador")
public class Entregador implements Serializable {

	private static final long serialVersionUID = -3782267884885702040L;

	private Integer id;
	private String nome;
	private String cpf;
	private Endereco endereco;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
