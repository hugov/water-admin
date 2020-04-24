package br.com.decimal.water.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import br.com.decimal.water.entity.Funcionalidade;
import br.com.decimal.water.service.FuncionalidadeService;

import java.util.List;

/**
 * 
 * @author Vitor Hugo Oliveira
 */
public class FuncionalidadeAction extends ActionSupport implements Preparable {

	private static final long serialVersionUID = 7445203433641887320L;

	private FuncionalidadeService service;

	private Integer id;
	private Funcionalidade funcionalidade;
	private List<Funcionalidade> funcionalidadeList;
	private String submitType;

	@Override
	public void prepare() throws Exception {
		service = new FuncionalidadeService();
	}

	public String list() {
		funcionalidadeList = service.list();

		return SUCCESS;
	}

	public String create() {
		service.create(funcionalidade);

		return SUCCESS;
	}

	public String retrieve() {
		funcionalidade = service.retrieve(id);

		return SUCCESS;
	}

	public String update() {
		if ("updatedata".equals(submitType)) {
			funcionalidade = service.retrieve(id);
			return INPUT;
		} else {
			service.update(funcionalidade);
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

	public Funcionalidade getFuncionalidade() {
		return funcionalidade;
	}

	public void setFuncionalidade(Funcionalidade funcionalidade) {
		this.funcionalidade = funcionalidade;
	}

	public List<Funcionalidade> getFuncionalidadeList() {
		return funcionalidadeList;
	}

	public void setFuncionalidadeList(List<Funcionalidade> funcionalidadeList) {
		this.funcionalidadeList = funcionalidadeList;
	}

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

}