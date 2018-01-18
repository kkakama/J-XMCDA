package io.github.oliviercailloux.y2017;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * 
 * @author MESKAOUI & BROCHEN
 *
 */
public class Alternative {
	private String id;
	private String name;
	
	
	/**
	 * Constructor of alternative class containing the folowing parameters
	 * @param id
	 * @param name
	 */
	public Alternative(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	// getters and setters
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
	
	/**
	 * 
	 * @param file
	 * 	name of the file of alternatives list
	 * @return
	 * list of alternatives in the correct format (ID, NAME)
	 */
	
	
}