package io.github.oliviercailloux.y2017.jxmcda.jsonxml;

import static org.junit.Assert.*;


import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import io.github.oliviercailloux.y2017.jxmcda.entities.Alternative;
import io.github.oliviercailloux.y2017.jxmcda.entities.AlternativeException;
import io.github.oliviercailloux.y2017.jxmcda.entities.AlternativeRanking;
import io.github.oliviercailloux.y2017.jxmcda.utils.JsonReadWrite;

public class JsonReadWriteTest {
	

	@Test
	public void test() {
		String actual="";
		String expected="";
		Alternative a1=new Alternative("a1","volvo");
		Alternative a2=new Alternative("a2","bmw");
		Alternative a3=new Alternative("a3","opel");
		Alternative a4=new Alternative("a1","volvo");
		
		AlternativeRanking altsInput = new AlternativeRanking();
		Multimap<Integer,Alternative> multi =ArrayListMultimap.create();
		try {
			altsInput.altsRanking(1, a1);
			altsInput.altsRanking(1, a4);
			altsInput.altsRanking(2, a3);
		} catch (AlternativeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonReadWrite j=new JsonReadWrite();
		//System.out.println(j.encodageJson(al.getMulti_ranking()));
		actual=j.encodageJsonAlt(altsInput.getMulti_ranking());
		expected="{\"alternatives\":[{\"rank\":1,\"name\":\"volvo\",\"id\":\"a1\"},{\"rank\":1,\"name\":\"volvo\",\"id\":\"a1\"},{\"rank\":2,\"name\":\"opel\",\"id\":\"a3\"}]}";

		//System.out.println(actual);
	    	
	    assertEquals(actual,expected);
	}

}
