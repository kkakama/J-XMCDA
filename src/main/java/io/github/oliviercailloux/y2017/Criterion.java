/**
 * 
 */
package io.github.oliviercailloux.y2017;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

/**
 * @author Nbencheri2
 *
 */
public class Criterion {

	private int id;

	private String name;

	public Criterion() {

	}

	public Criterion(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override 
	public String toString(){
		return "Criterion name/ID :" + name+"/"+id;
	}

	public void xmlToJson(String file) throws JSONException {
		JSONObject jsonObject = XML.toJSONObject(file);		
		System.out.println(jsonObject);
	}
	
	public String toJSONString() {
		Gson gson = new Gson();
		
		//gson.toJson(this, new FileWriter("D:\\Evaluations.json"));
		return gson.toJson(this);
	}
	
	public void toJSONFile() {
		Gson gson = new Gson();
		
		try {
			gson.toJson(this, new FileWriter("Criteria.json"));
		} catch (JsonIOException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
