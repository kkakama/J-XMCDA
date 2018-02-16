package io.github.oliviercailloux.y2017.jxmcda.entities;
	
	import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.json.JsonWriter;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset.Entry;
	/**
	 * 
	 * @author SAMI & ELISE
	 *
	 * Description: in this class, we are using the Google's API "Guava" and manipulate Alternative's MultiMap.
	 * We find that MultiMap is the best solution to associate our alternatives to ranks
	 * In order to be coherent with our project's classes, we decide to use JSON Processing 
	 */
	public class AlternativeRanking {
		
		private int rank;
		private Alternative alternative;
		private Multimap<Integer, Alternative> list_alternatives=ArrayListMultimap.create();
		
		
		// Getters and Setters
		public int getRank() {
			return rank;
		}
	
	
		public void setRank(int rank) {
			this.rank = rank;
		}
	
	
		public Alternative getAlternative() {
			return alternative;
		}
	
	
		public void setAlternative(Alternative alternative) {
			this.alternative = alternative;
		}
	
	
		public Multimap<Integer, Alternative> getMulti_ranking() {
			return list_alternatives;
		}
	
	
		public void setMulti_ranking(Multimap<Integer, Alternative> multi_ranking) {
			list_alternatives = multi_ranking;
		}
	
		/**
		 * The goal of this method is to attribute for each alternative a Rank, so our list of alternatives 
		 * must begins with rank "1" and must have successive ranks
		 * @param rank
		 * @param alt
		 * @throws AlternativeException
		 */
		public void altsRanking(int rank, Alternative alt)throws AlternativeException{
			int last_rank=0;
		
			for (Integer key : list_alternatives.keySet()) { 
					last_rank=key;
				 } 		 
			int next_rank=last_rank+1;
			if(list_alternatives.isEmpty() && rank==0){
				throw new AlternativeException("you need to enter a rank that starts with 1");

			}
			if(list_alternatives.isEmpty() && rank>1)
				throw new AlternativeException("The alternatives list is still empty, you need to enter a rank that starts with 1");
			
			else if(!list_alternatives.isEmpty() && rank>next_rank){
				throw new AlternativeException("you need to enter a rank that equals "+next_rank); 
			} 
			else{
			list_alternatives.put(rank, alt);
			}
				
		}
		
			//Showing the values of our multimap
			public void displayMap(Multimap<Integer, Alternative> list){
				for (Integer key : list.keySet()) { 
					// System.out.println(multi.get(key).toString());
					Collection<Alternative> alts=  list.get(key);
					 for(Alternative al:alts){
						 System.out.println(key.toString()+":"+al.getName());
					 } 		 
					 
				 } 		
			}
			
		
	}
