package io.github.oliviercailloux.y2017;
import org.junit.Test;


public class AlternativeRankingTest {

		@Test
		public void test() {
			Alternative a1=new Alternative("a1","volvo");
			Alternative a2=new Alternative("a1","volvo");
			Alternative a3=new Alternative("a1","volvo");
			Alternative a4=new Alternative("a1","volvo");
			
			AlternativeRanking alts = new AlternativeRanking();
			try {
				alts.altsRanking(1, a1);
				alts.altsRanking(1, a4);
				alts.altsRanking(2, a3);
			} catch (AlternativeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			alts.displayMap(alts.getMulti_ranking());
			System.out.println(alts.encodageJson(alts.getMulti_ranking()));
			
		}



}
