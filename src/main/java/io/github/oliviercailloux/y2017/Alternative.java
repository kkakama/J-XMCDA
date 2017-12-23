package io.github.oliviercailloux.y2017;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
/**
 * 
 * @author MESKAOUI & BROCHEN
 *
 */
public class Alternative {
	private int id;
	private String name;

	//private static ArrayList<Alternative> list_alternatives;
	
	
	/**
	 * Constructor of alternative class containing the folowing parameters without ranking (default value is 0)
	 * @param id
	 * @param name
	 */
	public Alternative(int id, String name) {
		this.id = id;
		this.name = name;
	
	}
	
	/**
	 * Second constructor of alternative class, this time containing the rank of each alternative created 
	 * @param id
	 * @param name
	 * @param rang
	 */
	public Alternative(int id, String name,int rank) {
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
	
	// Create Json and serialize
	public String toJson() {
		Jsonb jsonb = JsonbBuilder.create((new JsonbConfig().withFormatting(true)));
	    String json = jsonb.toJson(this);
		return json;
	
	}
	// Deserialize back
	   public Alternative JsontoAlternative(String AlternativeJson) {
	    	Jsonb jsonb = JsonbBuilder.create();
	    	return jsonb.fromJson(AlternativeJson, Alternative.class);
	    }

	

		
}