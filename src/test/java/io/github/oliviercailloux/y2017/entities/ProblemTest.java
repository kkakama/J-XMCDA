package io.github.oliviercailloux.y2017.entities;



import org.junit.Test;

import io.github.oliviercailloux.y2017.jxmcda.entities.Criterion;
import io.github.oliviercailloux.y2017.jxmcda.entities.Problem;

public class ProblemTest {

	@Test
	public void test() {
			Problem pb = new Problem("01");
		Criterion crit0= new Criterion(1,"c");
		Alternative alt0 = new Alternative("1","a");
		Criterion crit1= new Criterion(2,"c");
		Alternative alt1 = new Alternative("2","a");
		Evaluation eval0 = new Evaluation(alt0, crit0, 1.0);
		Evaluation eval1= new Evaluation(alt0, crit1, 2.0);
		Evaluation eval2 = new Evaluation(alt1, crit0, 3.0);
		Evaluation eval3 = new Evaluation(alt1, crit1, 4.0);
		pb.addCriterion(crit0);
		pb.addCriterion(crit1);
		pb.addAlternatives(alt0);
		pb.addAlternatives(alt1);
		pb.addEvaluations(eval0);
		pb.addEvaluations(eval1);
		pb.addEvaluations(eval2);
		pb.addEvaluations(eval3);
		String altsJson= pb.AlternativestoJson();
		String critsJson= pb.CriteriatoJson();
		String evalsJson= pb.EvaluationstoJson();
		System.out.println(critsJson);
	altsJson.equals("{\r\n" + 
				"        \"id\": \"1\",\r\n" + 
				"        \"name\": \"a\"\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"        \"id\": \"2\",\r\n" + 
				"        \"name\": \"a\"\r\n" + 
				"    }\r\n" + 
				"]\r\n" + 
				"\r\n" + 
				"[\r\n" + 
				"    {\r\n" + 
				"        \"id\": 1,\r\n" + 
				"        \"name\": \"c\"\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"        \"id\": 2,\r\n" + 
				"        \"name\": \"c\"\r\n" + 
				"    }");
	critsJson.equals("{\r\n" + 
				"        \"Criterion name :c , id :2\": 2.0,\r\n" + 
				"        \"Criterion name :c , id :1\": 1.0\r\n" + 
				"    }");
	evalsJson.equals( "{\r\n" + 
			"    \"io.github.oliviercailloux.y2017.Alternative@7e32c033\": {\r\n" + 
			"        \"Criterion name :c , id :2\": 2.0,\r\n" + 
			"        \"Criterion name :c , id :1\": 1.0\r\n" + 
			"    },\r\n" + 
			"    \"io.github.oliviercailloux.y2017.Alternative@7e0b37bc\": {\r\n" + 
			"        \"Criterion name :c , id :2\": 4.0,\r\n" + 
			"        \"Criterion name :c , id :1\": 3.0\r\n" + 
			"    }\r\n" + 
			"}");

	}

}
