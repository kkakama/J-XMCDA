package io.github.oliviercailloux.y2017;


import org.junit.Test;

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
		Alternative a1 =new Alternative(1, "volvo");
		System.out.println(a1.toJson());
		//a1.serializeAlternative(a1);
	}

}
