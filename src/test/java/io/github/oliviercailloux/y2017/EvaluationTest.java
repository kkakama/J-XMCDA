package io.github.oliviercailloux.y2017;
import org.junit.Test;

public class EvaluationTest {

	@Test
	public void test() {
		
		Criterion crit0= new Criterion(1,"c");
		Alternative alt0 = new Alternative(1,"a");
		Evaluation eval = new Evaluation(alt0, crit0, 1.0);
		System.out.println(eval.toJson());
		
	}

}
