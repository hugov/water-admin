package br.com.decimal.water.action;

import org.apache.struts2.StrutsTestCase;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.junit.jupiter.api.Test;

public class CategoriaActionTest extends StrutsTestCase {
	
	@Test
	public void testGetActionMapping() {
        ActionMapping mapping = getActionMapping("/categoriaList.action");
        assertNotNull(mapping);
        assertEquals("/water-admin", mapping.getNamespace());
        assertEquals("categoriaList.action", mapping.getName());
    }

}
