package io.github.oliviercailloux.y2017;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;

public class Evaluations{
	List <Criterion> crits;
	ArrayList<Alternative> alts;
	List<Double> val;
	// Evaluations par alternative

	private static Multimap<Alternative, Criterion> altCrit = ArrayListMultimap.create(); 
	private static Multimap<Multimap<Alternative, Criterion> ,Double> evals = ArrayListMultimap.create();
	public Evaluations(List<Double> val) {
		this.crits = Criterion.getcriterionList();
		this.alts = Alternative.getAlternativeList();
		this.val= val;
		
	}
	
	// How to implement all the elements if the mapList ?
	    public static void addEvaluation(Evaluations eva) {
	   
	    	 		for(int j = 0 ; j < eva.val.size(); j++) {
	    	 		 evals.put(getMultimap(eva),eva.val.get(j));
	    	 		}
	    	 	 }
	    	 		  
	
	    
	    private static Multimap<Alternative, Criterion> getMultimap(Evaluations eva) {

	      	for(int i = 0 ; i < eva.val.size(); i++) {
		    	 	for(int j = 0 ; j < eva.crits.size(); j++) {
		    	 		 	altCrit.put(eva.alts.get(i),eva.crits.get(j));
		    	 	}
	       }
	      	return altCrit;
	  }

	    public static void clearcriterionList() {
	        evals.clear();
	    }

	
	//Method to convert the Evaluation object to a JSON type
	public static String toJSONString() {
		Gson gson = new Gson();
		//gson.toJson(this, new FileWriter("D:\\Evaluations.json"));
		return gson.toJson(evals.asMap());
	}
	//Method to convert the Evaluations object to a JSON file
	public void toJSONFile() {
		Gson gson = new Gson();
		
		try {
			gson.toJson(this, new FileWriter("Evaluations.json"));
		} catch (JsonIOException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	//Method to convert the Evaluations object to a CSV file
	public String toCSV() throws JSONException, ParseException {
		
		String genreJson = toJSONString();
		JSONParser parser = new JSONParser();
		JSONArray array = (JSONArray)parser.parse(genreJson);
		try {
            JSONObject json = new JSONObject(array);
			return CDL.toString(new JSONArray(json.toString()));
		} catch (JSONException e) {
			System.out.println(e.getMessage());
		}
		
		return "";
	}
	
}
