package io.github.oliviercailloux.y2017;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class WebServiceDescrTest {
	@Test
	public void test() {
		Map<String, XmcdaModularTypes> map= new HashMap<>();
		WebServiceDescription w=new WebServiceDescription(map);
		map.put("id1", XmcdaModularTypes.ATTRIBUTE);
		map.put("id2", XmcdaModularTypes.CRITERION);

		w.setMap(map);
		w.displayMap(map);
		}
}
