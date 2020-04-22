package br.com.decimal.water.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import br.com.decimal.water.entity.Categoria;
import br.com.decimal.water.service.CategoriaService;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author Vitor Hugo Oliveira
 */
public class CategoriaAction extends ActionSupport implements Preparable {
    
	private static final long serialVersionUID = 7445203433641887320L;
	private static final Logger LOG = LogManager.getLogger(CategoriaAction.class.getName());
    
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
        LOG.info("Listando as categorias cadastradas .");
        
        categoriaList = service.list();
        
        return SUCCESS;
    }
    
    public String create() {
    	LOG.info("Cadastrando a categoria {} .", categoria);
    	
		service.create(categoria);
    	
        return SUCCESS;
    }
    
    public String retrieve() {
    	LOG.info("Recuperando a categoria {} .", id);
    	
		categoria = service.retrieve(id);
    	
        return SUCCESS;
    }
    
    public String update() {
    	
    	if("updatedata".equals(submitType)) {
        	categoria = service.retrieve(id);
        	return INPUT;
        } else {
        	LOG.info("Atualizando a categoria {} .", categoria);
        	service.update(categoria);
        }
    	
        return SUCCESS;
    }

    public String delete() {
        LOG.info("Apagando a categoria {} ." , id);
        
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