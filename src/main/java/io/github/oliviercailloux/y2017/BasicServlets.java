package io.github.oliviercailloux.y2017;

import io.github.oliviercailloux.y2017.Alternative;
import io.github.oliviercailloux.y2017.Criterion;
//import io.github.oliviercailloux.y2017.Evaluation;

/*
 *  below is the service interface and it’s implementation code.
 */
public interface BasicServlets {

	public Alternative getAlternative(String id);
	public Criterion getCriterion(int id);
	public Evaluation getEvaluation(int id);
	
	public Alternative addAlternative(Alternative alt);
	public  Criterion addCriterion(Criterion crit);
	
	public Evaluation setEvaluations(int id);

}
