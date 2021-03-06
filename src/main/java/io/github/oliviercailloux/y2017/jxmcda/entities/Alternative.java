package io.github.oliviercailloux.y2017.jxmcda.entities;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.*;


/**@Entity
 * 
 * @author MESKAOUI & BROCHEN
 * 
 *
 */
@Embeddable
@XmlRootElement(name = "alternative")
@XmlAccessorType (XmlAccessType.FIELD)
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
	
	
	
}