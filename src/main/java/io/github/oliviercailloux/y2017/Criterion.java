/**
 * 
 */
package io.github.oliviercailloux.y2017;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

	public int id;
	private String name;
	
	private static List<Criterion> criterionList;
	// Criterion constructor
	public Criterion(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	// List and method of all the Criteria
	 public static void createCriterionList() {
	        criterionList = new ArrayList<Criterion>();
	    }

	    public static void addcriterionToList(Criterion criterion) {
	        criterionList.add(criterion);
	    }

	    public static Criterion getcriterionAt(int location) {
	        return criterionList.get(location);
	    }

	    public static void clearcriterionList() {
	        criterionList.clear();
	    }

	    public static List<Criterion> getcriterionList() {
	         return criterionList;
	    }
	    
	 // Getter and Setter of the ID and the name   
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
	
	//Method to convert an XML file to  JSON file
	public void xmlToJson(String file) throws JSONException {
		JSONObject jsonObject = XML.toJSONObject(file);		
		System.out.println(jsonObject);
	}
	
	//Method to convert the Criterion object to a JSON type
	public String toJSONString() throws JsonIOException, IOException {
		Gson gson = new Gson();
		return gson.toJson(this);
	}


	//Method to convert the Criterion object to a JSON file
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
