package io.github.oliviercailloux.y2017;

import io.github.oliviercailloux.y2017.Alternative;
//import io.github.oliviercailloux.y2017.Criterion;
//import io.github.oliviercailloux.y2017.Evaluation;
import io.github.oliviercailloux.y2017.Response;

public interface BasicServlets {

	public Alternative getAlternative(String id);
	public Criterion getCriterion(int id);
	public Evaluation getEvaluation(int id);
	
	public Response addAlternative(Alternative alt);
	public Response addCriterion(Criterion crit);
	
	public Response setEvaluation(int id);

}
