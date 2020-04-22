package br.com.decimal.water.action;

import org.apache.struts2.StrutsTestCase;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.junit.jupiter.api.Test;

public class CategoriaActionTest extends StrutsTestCase {
	
	@Test
	public void testGetActionMapping() {
        ActionMapping mapping = getActionMapping("/water-admin/categoria!list.action");
        assertNotNull(mapping);
        assertEquals("/admin", mapping.getNamespace());
        assertEquals("categoria!list.action", mapping.getName());
    }

}
