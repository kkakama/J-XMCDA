package io.github.oliviercailloux.y2017;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement (name="service") 

public class Evaluation {

	private Criterion crit;
	private Alternative alt;
	private Double val;
	private int id;
	public Criterion getCrit() {
		return crit;
	}
	public void setCrit(Criterion crit) {
		this.crit = crit;
	}
	public Alternative getAlt() {
		return alt;
	}
	public void setAlt(Alternative alt) {
		this.alt = alt;
	}
	public Double getVal() {
		return val;
	}
	public void setVal(Double val) {
		this.val = val;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Evaluation [crit=" + crit + ", alt=" + alt + ", val=" + val + ", id=" + id + "]";
	}
	
	
	

	
}
