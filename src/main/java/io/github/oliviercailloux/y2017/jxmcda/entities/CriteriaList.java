package io.github.oliviercailloux.y2017.jxmcda.entities;


	import java.util.ArrayList;

	import javax.xml.bind.annotation.XmlAccessType;
	import javax.xml.bind.annotation.XmlAccessorType;
	import javax.xml.bind.annotation.XmlElement;
	import javax.xml.bind.annotation.XmlRootElement;

	@XmlRootElement(name = "criterion")
	@XmlAccessorType (XmlAccessType.FIELD)
	public class CriteriaList {
		
		  @XmlElement(name = "criteria")
		    private ArrayList<Criterion> criteria_list = null;

		public ArrayList<Criterion> getCriteria_list() {
			return criteria_list;
		}

		public void setCriteria_list(ArrayList<Criterion> criteria_list) {
			this.criteria_list = criteria_list;
		}

		  

	}
