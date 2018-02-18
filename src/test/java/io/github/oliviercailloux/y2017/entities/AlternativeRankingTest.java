package io.github.oliviercailloux.y2017.entities;

import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import io.github.oliviercailloux.y2017.jxmcda.entities.Alternative;
import io.github.oliviercailloux.y2017.jxmcda.entities.AlternativeException;
import io.github.oliviercailloux.y2017.jxmcda.entities.AlternativeRanking;


public class AlternativeRankingTest {

		@Test
		public void test() {
			Alternative a1=new Alternative("a1","volvo");
			Alternative a2=new Alternative("a2","volvo");
			Alternative a3=new Alternative("a3","volvo");
			Alternative a4=new Alternative("a4","volvo");
			Multimap<Integer, Alternative> multi=ArrayListMultimap.create();

			
			AlternativeRanking alts = new AlternativeRanking();
			try {
				alts.altsRanking(1, a1);
				alts.altsRanking(1, a4);
				alts.altsRanking(2, a3);
			} catch (AlternativeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
						
		}



}
