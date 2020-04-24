package br.com.decimal.water.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import br.com.decimal.water.entity.Preco;
import br.com.decimal.water.service.PrecoService;

import java.util.List;

/**
 * 
 * @author Vitor Hugo Oliveira
 */
public class PrecoAction extends ActionSupport implements Preparable {

	private static final long serialVersionUID = 7445203433641887320L;

	private PrecoService service;

	private Integer id;
	private Preco preco;
	private List<Preco> precoList;
	private String submitType;

	@Override
	public void prepare() throws Exception {
		service = new PrecoService();
	}

	public String list() {
		precoList = service.list();

		return SUCCESS;
	}

	public String create() {
		service.create(preco);

		return SUCCESS;
	}

	public String retrieve() {
		preco = service.retrieve(id);

		return SUCCESS;
	}

	public String update() {
		if ("updatedata".equals(submitType)) {
			preco = service.retrieve(id);
			return INPUT;
		} else {
			service.update(preco);
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

	public Preco getPreco() {
		return preco;
	}

	public void setPreco(Preco preco) {
		this.preco = preco;
	}

	public List<Preco> getPrecoList() {
		return precoList;
	}

	public void setPrecoList(List<Preco> precoList) {
		this.precoList = precoList;
	}

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

}