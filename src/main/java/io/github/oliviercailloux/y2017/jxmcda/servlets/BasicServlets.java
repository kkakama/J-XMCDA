package io.github.oliviercailloux.y2017.jxmcda.servlets;

import io.github.oliviercailloux.y2017.jxmcda.entities.Alternative;
import io.github.oliviercailloux.y2017.jxmcda.entities.Criterion;
import io.github.oliviercailloux.y2017.jxmcda.entities.Evaluation;

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
