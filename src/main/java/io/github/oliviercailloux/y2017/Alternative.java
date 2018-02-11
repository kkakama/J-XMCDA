package io.github.oliviercailloux.y2017;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * 
 * @author MESKAOUI & BROCHEN
 *
 */
@Entity
public class Alternative {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;
	@Column
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
	
	
	public Alternative() {
		// TODO Auto-generated constructor stub
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