package br.com.decimal.water.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import br.com.decimal.water.entity.Conta;
import br.com.decimal.water.service.ContaService;

/**
 * 
 * @author Vitor Hugo Oliveira
 */
public class IndexAction extends ActionSupport implements Preparable {

	private static final long serialVersionUID = 7445203433641887320L;

	private ContaService service;

	private Integer id = 1;
	private Conta conta;

	@Override
	public void prepare() throws Exception {
		service = new ContaService();
	}

	public String init() {
		conta = service.retrieve(id);

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

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

}