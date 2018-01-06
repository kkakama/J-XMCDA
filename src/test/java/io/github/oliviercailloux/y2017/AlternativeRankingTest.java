package io.github.oliviercailloux.y2017;

public class AlternativeRankingTest {
	
	public static void main(String[] args) throws AlternativeException {
		
		AlternativeRanking problem =new AlternativeRanking();
		Alternative a1=new Alternative("a1","volvo");
		Alternative a2=new Alternative("a2","bmw");
		Alternative a3=new Alternative("a3","volswagen");


		problem.altsRanking(1, a3);
		problem.altsRanking(2, a1);
		problem.altsRanking(3, a1);
		problem.altsRanking(4, a1);




		problem.displayMap(problem.list_alternatives); 
		System.out.println("\n");
	
		//problem.decodageJson("Alternatives.json");
		problem.displayMap(problem.decodageJson("Alternatives.json")); 
		

		
		
	}

}
