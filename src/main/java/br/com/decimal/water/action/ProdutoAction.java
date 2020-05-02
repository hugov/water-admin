package br.com.decimal.water.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import br.com.decimal.water.entity.Categoria;
import br.com.decimal.water.entity.Produto;
import br.com.decimal.water.service.CategoriaService;
import br.com.decimal.water.service.ProdutoService;

import java.util.List;

/**
 * 
 * @author Vitor Hugo Oliveira
 */
public class ProdutoAction extends ActionSupport implements Preparable {

	private static final long serialVersionUID = 7445203433641887320L;

	private ProdutoService service;
	private CategoriaService categoriaService;

	private Integer id;
	private Produto produto;
	private List<Produto> produtoList;
	private List<Categoria> categoriaList;
	private String submitType;

	@Override
	public void prepare() throws Exception {
		service = new ProdutoService();
		categoriaService = new CategoriaService();
		
		categoriaList = categoriaService.list();
		
	}
	
	public String list() {
		produtoList = service.list();

		return SUCCESS;
	}

	public String create() {
		service.create(produto);

		return SUCCESS;
	}

	public String retrieve() {
		produto = service.retrieve(id);

		return SUCCESS;
	}

	public String update() {
		if ("updatedata".equals(submitType)) {
			produto = service.retrieve(id);
			return INPUT;
		} else {
			service.update(produto);
		}

		return SUCCESS;
	}

	public String delete() {
		service.delete(id);

		return SUCCESS;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutoList() {
		return produtoList;
	}

	public void setProdutoList(List<Produto> produtoList) {
		this.produtoList = produtoList;
	}
	
	public List<Categoria> getCategoriaList() {
		return categoriaList;
	}

	public void setCategoriaList(List<Categoria> categoriaList) {
		this.categoriaList = categoriaList;
	}

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

}