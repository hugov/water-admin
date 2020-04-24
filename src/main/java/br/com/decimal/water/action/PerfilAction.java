package br.com.decimal.water.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import br.com.decimal.water.entity.Perfil;
import br.com.decimal.water.service.PerfilService;

import java.util.List;

/**
 * 
 * @author Vitor Hugo Oliveira
 */
public class PerfilAction extends ActionSupport implements Preparable {

	private static final long serialVersionUID = 7445203433641887320L;

	private PerfilService service;

	private Integer id;
	private Perfil perfil;
	private List<Perfil> perfilList;
	private String submitType;

	@Override
	public void prepare() throws Exception {
		service = new PerfilService();
	}

	public String list() {
		perfilList = service.list();

		return SUCCESS;
	}

	public String create() {
		service.create(perfil);

		return SUCCESS;
	}

	public String retrieve() {
		perfil = service.retrieve(id);

		return SUCCESS;
	}

	public String update() {
		if ("updatedata".equals(submitType)) {
			perfil = service.retrieve(id);
			return INPUT;
		} else {
			service.update(perfil);
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

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<Perfil> getPerfilList() {
		return perfilList;
	}

	public void setPerfilList(List<Perfil> perfilList) {
		this.perfilList = perfilList;
	}

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

}