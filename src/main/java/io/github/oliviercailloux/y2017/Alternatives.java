package io.github.oliviercailloux.y2017;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "alternatives")
@XmlAccessorType (XmlAccessType.FIELD)
public class Alternatives {
	
	  @XmlElement(name = "alternative")
	    private ArrayList<Alternative> alternatives = null;

	public ArrayList<Alternative> getAlternatives() {
		return alternatives;
	}

	public void setAlternatives(ArrayList<Alternative> alternatives) {
		this.alternatives = alternatives;
	}
	 
	    

}
