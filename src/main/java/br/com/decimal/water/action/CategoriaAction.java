package br.com.decimal.water.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import br.com.decimal.water.entity.Categoria;
import br.com.decimal.water.service.CategoriaService;

import java.util.List;

/**
 * 
 * @author Vitor Hugo Oliveira
 */
public class CategoriaAction extends ActionSupport implements Preparable {
    
	private static final long serialVersionUID = 7445203433641887320L;
    
	private CategoriaService service;
	
	private Integer id;
	private Categoria categoria;
	private List<Categoria> categoriaList;
	private String submitType;
	
    @Override
    public void prepare() throws Exception {
        service = new CategoriaService();
    }

    public String list() {
        categoriaList = service.list();
        
        return SUCCESS;
    }
    
    public String create() {
		service.create(categoria);
    	
        return SUCCESS;
    }
    
    public String retrieve() {
		categoria = service.retrieve(id);
    	
        return SUCCESS;
    }
    
    public String update() {
    	if("updatedata".equals(submitType)) {
        	categoria = service.retrieve(id);
        	return INPUT;
        } else {
        	service.update(categoria);
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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