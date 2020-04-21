package br.com.decimal.water.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import br.com.decimal.water.entity.Categoria;
import br.com.decimal.water.service.CategoriaService;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Acts as a controller to handle actions related to editing a Person.
 * 
 * @author bruce phillips
 * @author antonio sánchez
 */
public class CategoriaAction extends ActionSupport implements Preparable {
    
	private static final long serialVersionUID = 7445203433641887320L;
	private static final Logger LOG = LogManager.getLogger(CategoriaAction.class.getName());
    
	private CategoriaService service;
	
	private List<Categoria> categoriaList;
	
    @Override
    public void prepare() throws Exception {

    	// Busca as dependências para a classe funcionar
    	
        LOG.info("Prepared support data for Person entity.");
        
        service = new CategoriaService();
        
    }

    public String list() {
        LOG.info("Listing persons");
        
        categoriaList = service.list();
        
        return SUCCESS;
    }
    
    public String save() {
    	LOG.info("Executando o testes %d", 1);
    	
    	Categoria categoria = new Categoria();
		categoria.setDescricao("Água");
		categoria.setSituacao(0);
		
		service.create(categoria);
    	
//        if (person.getPersonId() == null) {
//            personService.insertPerson(person);
//            LOG.info("Created new Person: " + person);
//        } else {
//            personService.updatePerson(person);
//            LOG.info("Updated Person: " + person);
//        }
        return SUCCESS;
    }

    public String delete() {
        LOG.info("Deleted Person: " + 1);
        return SUCCESS;
    }

	public List<Categoria> getCategoriaList() {
		return categoriaList;
	}

	public void setCategoriaList(List<Categoria> categoriaList) {
		this.categoriaList = categoriaList;
	}
    
}