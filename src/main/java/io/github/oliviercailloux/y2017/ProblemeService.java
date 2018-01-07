package io.github.oliviercailloux.y2017;

import io.github.oliviercailloux.y2017.Alternative;
import io.github.oliviercailloux.y2017.Criterion;
import io.github.oliviercailloux.y2017.Evaluation;
import io.github.oliviercailloux.y2017.Response;

public class ProblemeService {

	public Alternative getAlternative(int id) {
		return null;
	} //id alt, id plm
	public Criterion getCriterion(int id) {
		return null;
	} //id crt, id plm
	public Evaluation getEvaluations(int id) {
		return null;
	}//id plm
	public Response addAlternative(Alternative alt) {
		return null;
	}//id alt, id plm
	public Response addCriterion(Criterion crit) {
		return null;
	}//id crt, id plm
	public Response setEvaluation(Evaluation eval) {
		return null;
	}//id alt, id plm, id crt, real eval
}
