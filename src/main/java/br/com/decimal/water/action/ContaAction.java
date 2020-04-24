package br.com.decimal.water.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import br.com.decimal.water.entity.Conta;
import br.com.decimal.water.service.ContaService;

import java.util.List;

/**
 * 
 * @author Vitor Hugo Oliveira
 */
public class ContaAction extends ActionSupport implements Preparable {

	private static final long serialVersionUID = 7445203433641887320L;

	private ContaService service;

	private Integer id;
	private Conta conta;
	private List<Conta> contaList;
	private String submitType;

	@Override
	public void prepare() throws Exception {
		service = new ContaService();
	}

	public String list() {
		contaList = service.list();

		return SUCCESS;
	}

	public String create() {
		service.create(conta);

		return SUCCESS;
	}

	public String retrieve() {
		conta = service.retrieve(id);

		return SUCCESS;
	}

	public String update() {
		if ("updatedata".equals(submitType)) {
			conta = service.retrieve(id);
			return INPUT;
		} else {
			service.update(conta);
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

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public List<Conta> getContaList() {
		return contaList;
	}

	public void setContaList(List<Conta> contaList) {
		this.contaList = contaList;
	}

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

}