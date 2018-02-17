package io.github.oliviercailloux.y2017.jxmcda.jsonxml;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import io.github.oliviercailloux.y2017.jxmcda.entities.WebServiceDescription;
import io.github.oliviercailloux.y2017.jxmcda.entities.XmcdaModularTypes;
import io.github.oliviercailloux.y2017.jxmcda.utils.SchemaGenerator;
/**
 * 
 * @author SAMI & NOUFISSA
 *
 */
public class SchemaGeneratorTest {
	
	    @Test
	    public void test() {
		Map<String, XmcdaModularTypes> map=new HashMap<>();
		WebServiceDescription w=new WebServiceDescription(map);
		map.put("id1", XmcdaModularTypes.ATTRIBUTE);
		map.put("id2", XmcdaModularTypes.CRITERION);

		w.setMap(map);
		SchemaGenerator s=new SchemaGenerator();
		try {
			s.marshalling(w);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
