package io.github.oliviercailloux.y2017;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import javax.json.Json;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.eclipse.yasson.internal.JsonBindingBuilder;
/**
 * 
 * @author MESKAOUI & BROCHEN
 *
 */
public class Alternative {
	private String id;
	private String name;
	private int rank;
	//private static ArrayList<Alternative> list_alternatives;
	
	
	/**
	 * Constructor of alternative class containing the folowing parameters without ranking (default value is 0)
	 * @param id
	 * @param name
	 */
	public Alternative(String id, String name) {
		this.id = id;
		this.name = name;
		rank=0;
	}
	
	/**
	 * Second constructor of alternative class, this time containing the rank of each alternative created 
	 * @param id
	 * @param name
	 * @param rang
	 */
	public Alternative(String id, String name,int rank) {
		this.id = id;
		this.name = name;
		this.rank=rank;
	}
	

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	//Create Json B and Serialize 
	public void serializeAlternative(Alternative alt) throws Exception{
		// Create Jsonb and serialize
	/*	Jsonb jsonb = JsonbBuilder.create();
		String result = jsonb.toJson(dog); */
		//String result = jso.toJson(alt);
	

	}	
	/**
	 * 
	 * @param file
	 * 	name of the file of alternatives list
	 * @return
	 * list of alternatives in the correct format (ID, NAME)
	 */

	
	

	public static void main(String[] args) {

			Alternative a1 =new Alternative("id1", "volvo");
			System.out.println(a1.rank);
			//a1.serializeAlternative(a1);
			
	} 
		
		
		


}