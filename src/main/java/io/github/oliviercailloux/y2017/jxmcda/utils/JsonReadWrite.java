package io.github.oliviercailloux.y2017.jxmcda.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonString;
import javax.json.JsonStructure;
import javax.json.JsonValue;
import javax.json.JsonWriter;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import org.eclipse.yasson.internal.serializer.JsonValueSerializer;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import io.github.oliviercailloux.y2017.jxmcda.entities.Alternative;
import io.github.oliviercailloux.y2017.jxmcda.entities.AlternativeException;
import io.github.oliviercailloux.y2017.jxmcda.entities.AlternativeRanking;
import io.github.oliviercailloux.y2017.jxmcda.entities.XmcdaModularTypes;

public class JsonReadWrite {
	
/**
 * encoding the List of Alternatives to json Format
 * @param alternatives (our multimap)
 * @return  Json format
 */
	public String encodageJsonAlt(Multimap<Integer,Alternative> alternatives){
		Collection<Alternative> alts;
		JsonObjectBuilder ob= Json.createObjectBuilder();
	    JsonArrayBuilder jb=Json.createArrayBuilder();
	    for(Integer key:alternatives.keySet()){
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
		
		return jsonData;
		
	}
	
	/**
	 * the goal of this function is to read all alternatives from json format 
	 * to fill our multimap.
	 * @param jsonFileName
	 * @return our multimap
	 */

	public Multimap<Integer,Alternative> decodageJsonAlt(String jsonformat){
		// Declarations
		Multimap<Integer,Alternative> alternatives =ArrayListMultimap.create();
		int i=0;
		JsonReader reader = Json.createReader(new StringReader(jsonformat));
			
			JsonObject alts = reader.readObject();
			JsonArray arrAlts= alts.getJsonArray("alternatives");
			
			for(i=0;i<arrAlts.size();i++){
				JsonObject jsonObject = arrAlts.getJsonObject(i);
				int rank= jsonObject.getInt("rank");
				String idAlt=jsonObject.getString("id");
				String nameAlt=jsonObject.getString("name");
				alternatives.put(rank, new Alternative(idAlt, nameAlt));
	               }
	               			
			return alternatives;
	}
	
	/**
	 * With this function we can create a Json File saved in the project repository
	 * @param map
	 * 	
	 */
	public String encodageJsonWebService(Map<String,XmcdaModularTypes> map){	
		JsonObjectBuilder buil =Json.createObjectBuilder();
		for(Map.Entry<String, XmcdaModularTypes> entry : map.entrySet()){
		   XmcdaModularTypes valeur = entry.getValue(); 
		   buil.add(entry.getKey(), String.valueOf(valeur));
		}
		StringWriter stWriter = new StringWriter();
		JsonObject mod = buil.build();
		try (JsonWriter jsonWriter = Json.createWriter(stWriter)) {
			jsonWriter.writeObject(mod);
		}
		//our json code
		String jsonData = stWriter.toString();
		
		return jsonData;
		
	}
		
	/**
	 * With this function we can read Json File's content and stock it in our Map
	 * @param filename
	 * 				correspond to json file's name
	 * @return
	 */
	public Map<String,XmcdaModularTypes> decodageJsonWeb(String jsonFormat){
		String key = null;
		XmcdaModularTypes value = null;
		Map<String,XmcdaModularTypes> jsonMap = new HashMap<String, XmcdaModularTypes>();
		String jsondata="";
		try (JsonReader reader = Json.createReader(new StringReader(jsonFormat))){
			JsonValue jsonst = reader.readObject();
			jsondata= jsonst.toString();
			/**
			 * @author sami 
			 * I've to change this code too, to have a clean and pretty code (time constraint)
			 * 
			 */
			final JsonParser parser = Json.createParser(new StringReader(jsondata));
			
		   while (parser.hasNext()) {
		         final Event event = parser.next();
		         switch (event) {
		         case KEY_NAME:
		        	  key = parser.getString();
		        	 break;
		            case VALUE_STRING:
		            	 value = XmcdaModularTypes.valueOf(parser.getString());
		            	 break; 
		   	        }
		         if(key!=null && value!=null)
			        jsonMap.put(key, value);
		    } 
		} 
		
		
		return jsonMap;	
		
	}


}
