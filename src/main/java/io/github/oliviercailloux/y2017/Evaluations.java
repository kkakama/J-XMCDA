package io.github.oliviercailloux.y2017;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;

public class Evaluations{
	List <Criterion> crits;
	List<Alternative> alt;
	List<Double> val;
	// Evaluations par alternative
	final Multimap<Alternative, Criterion> Evals = ArrayListMultimap.create();
	
	public Evaluations(List<Double> val) {
		this.crits = Criterion.getcriterionList();
		this.alt = Alternative.getAlternativeList();
		this.val= val;
		
	}
	
	//Method to convert the Evaluation object to a JSON type
	public String toJSONString() {
		Gson gson = new Gson();
		//gson.toJson(this, new FileWriter("D:\\Evaluations.json"));
		return gson.toJson(this);
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
	public String toCSV() throws JSONException {
		
		String genreJson = toJSONString();
		JSONArray array = new JSONArray(genreJson);
		try {
            JSONObject json = new JSONObject(array);
			return CDL.toString(new JSONArray(json.toString()));
		} catch (JSONException e) {
			System.out.println(e.getMessage());
		}
		
		return "";
	}
	
}
