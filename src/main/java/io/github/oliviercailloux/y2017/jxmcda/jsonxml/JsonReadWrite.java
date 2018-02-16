package io.github.oliviercailloux.y2017.jxmcda.jsonxml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Collection;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonString;
import javax.json.JsonValue;
import javax.json.JsonWriter;
import javax.json.stream.JsonParser;

import org.eclipse.yasson.internal.serializer.JsonValueSerializer;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import io.github.oliviercailloux.y2017.jxmcda.entities.Alternative;
import io.github.oliviercailloux.y2017.jxmcda.entities.AlternativeException;
import io.github.oliviercailloux.y2017.jxmcda.entities.AlternativeRanking;

public class JsonReadWrite {
	
/**
 * encoding the List of Alternatives to json Format
 * @param alternatives (our multimap)
 * @return  Json format
 */
	public String encodageJson(Multimap<Integer,Alternative> alternatives){
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

	public Multimap<Integer,Alternative> decodageJson(String jsonformat){
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
	

		

}
