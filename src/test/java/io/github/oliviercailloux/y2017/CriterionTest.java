package io.github.oliviercailloux.y2017;

import org.junit.Test;

public class CriterionTest {

	@Test
	public void testToJson() {
		
		Criterion criterion = new Criterion(1,"a");
		String critJson = criterion.toJson();
		System.out.println(critJson);
		
		
	}

}
