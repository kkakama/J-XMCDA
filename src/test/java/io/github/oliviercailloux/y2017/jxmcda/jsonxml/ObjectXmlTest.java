package io.github.oliviercailloux.y2017.jxmcda.jsonxml;

import java.util.ArrayList;
import org.junit.Test;

import io.github.oliviercailloux.y2017.jxmcda.entities.Alternative;
import io.github.oliviercailloux.y2017.jxmcda.entities.Alternatives;
import io.github.oliviercailloux.y2017.jxmcda.entities.Criterion;
import io.github.oliviercailloux.y2017.jxmcda.utils.ObjectXml;
public class ObjectXmlTest {
	@Test
	public void test() {

		Alternative a1=new Alternative("a1","volvo");
		Alternative a2=new Alternative("a2","bmw");
		Alternative a3=new Alternative("a3","mercedes");
		
		Alternatives alts=new Alternatives();
		alts.setAlternatives(new ArrayList<Alternative>());
	
	    //Create alternatives
		alts.getAlternatives().add(a1);
		alts.getAlternatives().add(a2);
		alts.getAlternatives().add(a3);

		Criterion c1=new Criterion(1,"c1");
		Criterion c2=new Criterion(2,"c2");
		Criterion c3=new Criterion(1,"c3");
	
		
		ObjectXml x=new ObjectXml();
		/*
		x.marshalling(new Alternative("a1","volvo"));
		System.out.println("test marshalling Alternative ");
		x.marshalling(alts);
		
		
		// test of marshalling criteria 
		System.out.println("test marshalling Evaluation ");
		
		x.marshalling(new Evaluation(a1,c1, 1.1));
		
		System.out.println("test marshalling criterion ");
		x.marshalling(new Criterion(1,"critere"));
		System.out.println("test marshalling criteria list ");
		
		
		CriteriaList crits=new CriteriaList();
		crits.setCriteria_list(new ArrayList<Criterion>());
	
	    crits.getCriteria_list().add(c1);
	    crits.getCriteria_list().add(c2);
	    crits.getCriteria_list().add(c3); 
	    x.marshalling(crits);
	    */
	    //x.unmarshalling("");
		x.marshalling(alts);
	
	}


}
