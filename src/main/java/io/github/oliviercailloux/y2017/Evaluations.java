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

public class Evaluations {
	
	// Evaluations par alternative
	final Multimap<Alternative, Criterion> Alternatioves = ArrayListMultimap.create();
	
	public String toJSONString() {
		Gson gson = new Gson();
		
		//gson.toJson(this, new FileWriter("D:\\Evaluations.json"));
		return gson.toJson(this);
	}
	
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
	
	public String toCSV() {
		
		String genreJson = toJSONString();
        
		try {
            JSONObject json = new JSONObject(genreJson);
			return CDL.toString(new JSONArray(json.toString()));
		} catch (JSONException e) {
			System.out.println(e.getMessage());
		}
		
		return "";
	}
	
}
