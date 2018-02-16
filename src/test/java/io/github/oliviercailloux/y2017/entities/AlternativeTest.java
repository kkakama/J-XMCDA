package io.github.oliviercailloux.y2017.entities;


import org.junit.Test;

import io.github.oliviercailloux.y2017.jxmcda.entities.Alternative;

public class AlternativeTest {
	/**
	 * 
	 * @param file
	 * 	name of the file of alternatives list
	 * @return
	 * list of alternatives in the correct format (ID, NAME)
	 */

	
	@Test
	public void test() {
		Alternative a1 =new Alternative("a1", "volvo");
		System.out.println("id="+a1.getId()+", name="+a1.getName());
	}

}
