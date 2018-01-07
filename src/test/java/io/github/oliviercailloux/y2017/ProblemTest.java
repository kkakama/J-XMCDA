package io.github.oliviercailloux.y2017;



import org.junit.Test;

public class ProblemTest {

	@Test
	public void test() {
		Problem pb = new Problem("01");
		Criterion crit0= new Criterion(1,"c");
		Alternative alt0 = new Alternative(1,"a");
		Criterion crit1= new Criterion(2,"c");
		Alternative alt1 = new Alternative(2,"a");
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
		System.out.println(pb.AlternativestoJson());
		System.out.println(pb.CriteriatoJson());
		System.out.println(pb.EvaluationstoJson());

	}

}
