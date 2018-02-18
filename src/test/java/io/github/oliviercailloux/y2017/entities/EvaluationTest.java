package io.github.oliviercailloux.y2017.entities;
import org.junit.Test;

import io.github.oliviercailloux.y2017.jxmcda.entities.Alternative;
import io.github.oliviercailloux.y2017.jxmcda.entities.Criterion;
import io.github.oliviercailloux.y2017.jxmcda.entities.Evaluation;

public class EvaluationTest {

	@Test
	public void test() {
				Criterion crit0= new Criterion(1,"c");
		Alternative alt0 = new Alternative("1","a");
		Evaluation eval = new Evaluation(alt0, crit0, 1.0);
		String evalJson = eval.toJson();
		evalJson.equals("{\r\n" + 
				"    \"alt\": {\r\n" + 
				"        \"id\": \"1\",\r\n" + 
				"        \"name\": \"a\"\r\n" + 
				"    },\r\n" + 
				"    \"crit\": {\r\n" + 
				"        \"id\": 1,\r\n" + 
				"        \"name\": \"c\"\r\n" + 
				"    },\r\n" + 
				"    \"val\": 1.0\r\n" + "}");
		
	}

}
