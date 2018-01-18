package io.github.oliviercailloux.y2017;
	
	import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonValue;
import javax.json.JsonWriter;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder.ListMultimapBuilder;
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
		public static Multimap<Integer, Alternative> list_alternatives=ArrayListMultimap.create();
		
		
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
			int last_rank=list_alternatives.size();
			int next_rank=last_rank+1;
			if(list_alternatives.isEmpty() && rank==0){
				throw new AlternativeException("you need to enter a rank that starts with 1");

			}
			if(list_alternatives.isEmpty() && rank>1)
				throw new AlternativeException("The alternatives list is still empty, you need to enter a rank that starts with 1");
			
			else if(!list_alternatives.isEmpty() && rank!=next_rank){
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
			/***
			 * this function has for goal creating json file of the list of alternatives
			 * @param alternatives
			 * 					  our multimap
			 */
		
			
			public void encodageJson(Multimap<Integer,Alternative> alternatives){
				Collection<Alternative> alts;
				JsonObjectBuilder ob= Json.createObjectBuilder();
			    JsonArrayBuilder jb=Json.createArrayBuilder();
			    Set keys = alternatives.keySet();
				Iterator it = keys.iterator();
				while (it.hasNext()){
				   Integer key = (Integer) it.next(); 
				    alts=  alternatives.get(key);
					 for(Alternative al:alts){
						
						   jb.add(Json.createObjectBuilder().add("rank", key).add("name"
								   , al.getName()).add("id", al.getId()));


					 } 	
				}
			    
			    JsonArray contactsArr = jb.build();
			    ob.add("alternatives",contactsArr);
			    
			    StringWriter stWriter = new StringWriter();
				JsonWriter jsonWriter = Json.createWriter(stWriter);
				JsonObject empObj = ob.build();
			    jsonWriter.writeObject(empObj);
				jsonWriter.close();	 
				String jsonData = stWriter.toString();
				System.out.println(jsonData);
				
				try {
					FileWriter f = new FileWriter("Alternatives.json");
					f.write(jsonData);
					f.close();
				} catch (IOException e) {
					e.printStackTrace();
				} 
				
			}
			/**
			 * the goal of this function is to read all alternatives from json file and 
			 * fill our multimap.
			 * @param jsonFileName
			 * @return
			 */
			public Multimap<Integer,Alternative> decodageJson(String jsonFileName){
				// Declarations
				Multimap<Integer,Alternative> alternatives =ArrayListMultimap.create();
				String id="";
				String name="";
				int rank=0;
				JsonReader reader;
				try {
					reader = Json.createReader(new FileReader(jsonFileName));
					JsonObject alts = reader.readObject();
					reader.close();
					JsonArray arrAlts= alts.getJsonArray("alternatives");
					for(JsonValue value : arrAlts){
		                final JsonParser parser = Json.createParser(new StringReader(value.toString()));
		                String key = "";
		                String v = "";
		                while (parser.hasNext()){
		       	         final Event event = parser.next();
		       	         switch (event) {
		       	            case KEY_NAME:
		       	                 key = parser.getString();			       	                 
		       	                 break;
		       	            case VALUE_STRING:
		       	                  v = parser.getString();
		       	                 break;
		       	            case VALUE_NUMBER:
		       	            	rank=parser.getInt();
		       	            	break;
		       	             
		       	               
		       	                 } 
		       	       //testing on key to know if it's an ID or NAME
       	               switch(key){
       	               case "id":
       	                	  id= v;break;
       	               case "name":
   	                	  name= v;break;
       
	                	 
       	               }
       	               
		       	         		
		            }
		                //Insertion of our variables in the multimap
		                alternatives.put(rank, new Alternative(id, name));
		                
		             //closing the parser
		             parser.close();
		            }
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
				return alternatives;	
				
			}
				
				
			
	
	}
