package io.github.oliviercailloux.y2017.entities;

import org.junit.Test;

import io.github.oliviercailloux.y2017.jxmcda.entities.Criterion;

public class CriterionTest {

	@Test
	public void testToJson() {
		
		Criterion criterion = new Criterion(1,"a");
		String critJson = criterion.toJson();
		System.out.println(critJson);
		critJson.equals("\n{\n" + "    \"id\": 1,\n" + "    \"name\": \"a\"\r\n" + "}");
		
	}
		
		
	}

}
