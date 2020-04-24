package br.com.decimal.water.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import br.com.decimal.water.entity.Entregador;
import br.com.decimal.water.service.EntregadorService;

import java.util.List;

/**
 * 
 * @author Vitor Hugo Oliveira
 */
public class EntregadorAction extends ActionSupport implements Preparable {

	private static final long serialVersionUID = 7445203433641887320L;

	private EntregadorService service;

	private Integer id;
	private Entregador entregador;
	private List<Entregador> entregadorList;
	private String submitType;

	@Override
	public void prepare() throws Exception {
		service = new EntregadorService();
	}

	public String list() {
		entregadorList = service.list();

		return SUCCESS;
	}

	public String create() {
		service.create(entregador);

		return SUCCESS;
	}

	public String retrieve() {
		entregador = service.retrieve(id);

		return SUCCESS;
	}

	public String update() {
		if ("updatedata".equals(submitType)) {
			entregador = service.retrieve(id);
			return INPUT;
		} else {
			service.update(entregador);
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

	public Entregador getEntregador() {
		return entregador;
	}

	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
	}

	public List<Entregador> getEntregadorList() {
		return entregadorList;
	}

	public void setEntregadorList(List<Entregador> entregadorList) {
		this.entregadorList = entregadorList;
	}

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

}