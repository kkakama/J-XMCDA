package io.github.oliviercailloux.y2017;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

public class Test{

public static void main(String[] args) {
	Criterion crit = new Criterion(1,"c") ;
	Criterion crit2 = new Criterion(2,"c") ;
	Criterion.addcriterionToList(crit);
	Criterion.addcriterionToList(crit2);
	Alternative alt1 = new Alternative("a01","Sami");
	Alternative alt2 = new Alternative("a01","nouf");
	Alternative.addAlternativeToList(alt1);
	Alternative.addAlternativeToList(alt2);
	List<Double> eval = new CopyOnWriteArrayList <Double>();
	eval.add((double) 1);
	eval.add((double) 2);
	
	Evaluations evals = new Evaluations(eval);
	Evaluations.addEvaluation(evals);
	
	 String EvaluationCSV = Evaluations.toJSONString();
	try {
		System.out.println(EvaluationCSV);
	} catch (Exception e) {
		e.printStackTrace();
	}
		
}

}



