package io.github.oliviercailloux.y2017;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
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
