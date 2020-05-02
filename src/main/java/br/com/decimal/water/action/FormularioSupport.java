package br.com.decimal.water.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import br.com.decimal.water.entity.Categoria;
import br.com.decimal.water.service.CategoriaService;

public class FormularioSupport extends ActionSupport implements Preparable {

	private static final long serialVersionUID = -4070090088460011891L;

	// Serviços auxiliares
	private CategoriaService categoriaService;
	
	// Listas auxiliares
	private List<Categoria> categoriaList;
	
	@Override
	public void prepare() throws Exception {
		categoriaService = new CategoriaService();
	}
	
	public String getCategoria() {
		categoriaList = categoriaService.list();
		return SUCCESS;
	}

	public List<Categoria> getCategoriaList() {
		return categoriaList;
	}

	public void setCategoriaList(List<Categoria> categoriaList) {
		this.categoriaList = categoriaList;
	}
	
}
