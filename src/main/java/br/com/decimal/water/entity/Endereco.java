package br.com.decimal.water.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity(name="Endereco")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 4788936467618005488L;

	private Integer id;
	private String logradouro;
	private String cep;
	private String complemento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
