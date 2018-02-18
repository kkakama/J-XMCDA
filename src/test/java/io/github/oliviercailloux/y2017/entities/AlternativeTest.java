package io.github.oliviercailloux.y2017.entities;


import static org.junit.Assert.*;

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
		assertEquals("a1",a1.getId());
		assertEquals("volvo",a1.getName());

	}

}
