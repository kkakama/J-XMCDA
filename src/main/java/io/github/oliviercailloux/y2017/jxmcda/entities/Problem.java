package io.github.oliviercailloux.y2017.jxmcda.entities;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonStructure;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
*/
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.persistence.Entity;
import javax.persistence.Id;

/*
import javax.json.stream.JsonGenerator;
import com.google.common.collect.ArrayListMultimap;
*/
import com.google.common.collect.HashBasedTable;
/*
import com.google.common.collect.ImmutableMap;
*/
import com.google.common.collect.Table;
@Entity
public class Problem {
	@Id
	private String id;
	private Problem problem;
	private  List<Criterion> criteria= Collections.synchronizedList( new ArrayList<Criterion>());
	private  List<Alternative> alternatives= Collections.synchronizedList( new ArrayList<Alternative>());
	//private AlternativeRanking alternativesRanking= new AlternativeRanking();
	private Table<Alternative, Criterion, Double> evals = HashBasedTable.create() ;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	// The Problem class is a singleton class 
	 public Problem(String id) {
		 this.id=id;
	 }
	 
	 // We could access to the Problem by using this method
	
	    public   Problem getproblem() {
	        return problem;
	    }
	 
	// Each problem has a List of Criteria, so we could access to this list using the following method
	    
	    public   List<Criterion> getCriteria() {
	        return criteria;
	    }


	 // Each problem has a List of Alternatives, so we could access to this list using the following method
	    
	    public List<Alternative> getAlternatives() {
		return alternatives ;
	    }
    
    // Each problem has a List of Evaluations, so we could access to this list using the following method
    
	    public Table<Alternative, Criterion, Double> getEvaluations() {
		return evals ;
	    }
    
	    public   void addCriterion(Criterion crit) {
	       criteria.add(crit);
	    }


 // Each problem has a List of Alternatives, so we could access to this list using the following method
    
	    public void addAlternatives(Alternative alt) {
		   alternatives.add(alt);
	    }
    
 // method to add the Evaluation table
	
	    public void addEvaluations(Evaluation eval) {
			evals.put(eval.alt,eval.crit, eval.val);

	    }	  
 // Create Json and serialize
    
    
	    public String CriteriatoJson() {
			Jsonb jsonb = JsonbBuilder.create((new JsonbConfig().withFormatting(true)));
		    	String json = jsonb.toJson(criteria);
			return json;

	    }
    
	    public String AlternativestoJson() {
			Jsonb jsonb = JsonbBuilder.create((new JsonbConfig().withFormatting(true)));
		        String json = jsonb.toJson(alternatives);
			return json;

	    }
	    public String EvaluationstoJson() {

			Jsonb jsonb = JsonbBuilder.create((new JsonbConfig().withFormatting(true)));
		    String json = jsonb.toJson(evals.rowMap());
		   /* StringWriter stringWriter = new StringWriter();
			JsonWriterFactory writerFactory = Json.createWriterFactory(ImmutableMap.of(JsonGenerator.PRETTY_PRINTING, true));
			try (JsonWriter jsonWriter = writerFactory.createWriter(stringWriter)) {
				jsonWriter.write(json);
	    }
		return stringWriter.toString();*/
		
		return json;
	    }


}
   
