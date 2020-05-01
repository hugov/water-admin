package br.com.decimal.water.entity;

import java.time.LocalDateTime;

//@Entity(name = "PerfilFuncionalidade")
public class PerfilFuncionalidade {

	//@ManyToOne
	//@JoinColumn(name = "perfilId")
	private Perfil perfil;

	//@ManyToOne
	//@JoinColumn(name = "funcionalidadeId")
	private Funcionalidade funcionalidade;

	private LocalDateTime dataRegistro;

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Funcionalidade getFuncionalidade() {
		return funcionalidade;
	}

	public void setFuncionalidade(Funcionalidade funcionalidade) {
		this.funcionalidade = funcionalidade;
	}

	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

}
