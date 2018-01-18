package io.github.oliviercailloux.y2017;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;



public class Evaluation{

	public Criterion crit;
	public Alternative alt;
	public Double val;
	
	
	public Evaluation(Alternative alt, Criterion crit, Double val) {
		this.alt = alt;
		this.crit = crit;
		this.val = val;

	}
	
	// Getters and Setters
	public Alternative getalt() {
		return alt;
	}

	public void setalt(Alternative alt) {
		this.alt = alt;
	}

	public Criterion getCrit() {
		return crit;
	}

	public void setCrit(Criterion  crit) {
		this.crit= crit;
	}
	public Double getVal() {
		return val;
	}

	public void setVal(Double  val) {
		this.val= val;
	}	
	    
//Create Json and serialize
public String toJson() {

				Jsonb jsonb = JsonbBuilder.create((new JsonbConfig().withFormatting(true)));
				String json = jsonb.toJson(this);
				return json;
			
			
	}
//Deserialize back
public Evaluation JsontoEvaluation(String EvalJson) {
	Jsonb jsonb = JsonbBuilder.create();
	return jsonb.fromJson(EvalJson, Evaluation.class);
}

}