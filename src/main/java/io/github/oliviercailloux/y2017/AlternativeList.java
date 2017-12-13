package io.github.oliviercailloux.y2017;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;*/

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Collections2;
import com.google.common.collect.Multimap;

/**
 * 
 * @author MESKAOUI & BROCHEN 
 *
 */

public class AlternativeList {
	
	
	private static ArrayList<Alternative> list_alternatives;
	public static Multimap<Integer,Alternative> multi= ArrayListMultimap.create();
	
	
	public static void createAlternativeList() {
		list_alternatives = new ArrayList<Alternative>();
    }

    public static void addAlternativeToList(Alternative Alternative) {
    	list_alternatives.add(Alternative);
    }
    public static void clearRang(int rang){
    }
    public static void clearAlternative(Alternative alt){
    	
    }
    public static void clearAlternativeList() {
    	list_alternatives.clear();
    }

    public static ArrayList<Alternative> getAlternativeList() {
         return list_alternatives;
    }
    
  
	/**
	 * this function makes it possible to associate each alternative group with a rank using Multimap (Guava API) 
	 * @param list
	 * 			 the list of alternatives already 
	 */
	public void AltsRanking(ArrayList<Alternative> list){
		//browsing the list of alternatives to put for each rank a group of alternatives associated to it
		for(Alternative alt: list){
			multi.put(alt.getRank(), alt);		
		}
	

	}
	public void displayMap(){
		for (Integer key : multi.keySet()) { 
			 System.out.println(key.toString());
			// System.out.println(multi.get(key).toString());
			Collection<Alternative> alts=  multi.get(key);
			 for(Alternative al:alts){
				 System.out.println(al.getName());
			 } 		 
			 
		 } 		
	}
	//Clear all the multimap
	public void clearAllAlternatives(){
		multi.clear();
	}
	// remove a rank of alternatives
	public void removeRankAlternative(int Rank){
		multi.removeAll(Rank);
	}
   
public static void main(String[] args) {
	ArrayList<Alternative> list=new ArrayList<Alternative>();
	AlternativeList l=new AlternativeList();
	Alternative a1=new Alternative("a1", "VOLVO");
	Alternative a2=new Alternative("a2", "BMW",1);
	Alternative a3=new Alternative("a3", "VOLSWAGEN",1);
	Alternative a4=new Alternative("a4", "MERCEDES",1);
	Alternative a5=new Alternative("a5", "FERRARI",2);
	Alternative a6=new Alternative("a6", "RENAULT",2);
	Alternative a7=new Alternative("a7", "PORSH",2);


	list.add(a1);list.add(a2);list.add(a3);list.add(a4);list.add(a5);list.add(a6); list.add(a7);
	l.AltsRanking(list);
	l.displayMap();
	//l.removeRank(1);
	//l.displayMap();

	
	
	 // Getting values
	  
	  

}
}
