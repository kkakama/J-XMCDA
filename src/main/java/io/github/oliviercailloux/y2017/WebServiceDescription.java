package io.github.oliviercailloux.y2017;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.*;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonWriter;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;




/**
 * 
 * @author KAKAMA & SAMI
 *
 */ 
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class WebServiceDescription {
	//Map attribute that will contain our pairs
    /*@XmlJavaTypeAdapter(MyMapAdapter.class)
    @XmlElement */
	private Map<String, XmcdaModularTypes> map =new HashMap<String, XmcdaModularTypes>(); 	
	
	public WebServiceDescription(Map<String, XmcdaModularTypes> map) {
		this.map = map;
	}

	// empty constructor for encoding decoding with jaxb
	public WebServiceDescription(){
	
	} 

	public void removeFromMap(String id){
		this.map.remove(id);
	}
	// getters and setters
	public  Map<String, XmcdaModularTypes> getMap() {
		return map;
	}
	public  void setMap(Map<String, XmcdaModularTypes> map) {
		this.map= map;
	}
	/**
	 * With this function we can create a Json File saved in the project repository
	 * @param map
	 * 	
	 */
	public String encodageJson(Map<String,XmcdaModularTypes> map){	
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
	 * Write Json Code in file
	 * @param jsonFileName -- name of file 
	 */
	public void createJson(String jsonFileName){
		try (FileWriter f = new FileWriter(jsonFileName)){
			f.write(encodageJson(map));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * With this function we can read Json File's content and stock it in our Map
	 * @param filename
	 * 				correspond to json file's name
	 * @return
	 */
	public Map<String,XmcdaModularTypes> decodageJson(String filename){
		String key = null;
		XmcdaModularTypes value = null;
		Map<String,XmcdaModularTypes> jsonMap = new HashMap<String, XmcdaModularTypes>();
		String jsondata="";
		try (JsonReader reader = Json.createReader(new FileReader(filename))){
			JsonStructure jsonst = reader.read();
			jsondata= jsonst.toString();
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
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return jsonMap;	
		
	}
	public void displayMap(Map<String,XmcdaModularTypes> map){
		for(String key:map.keySet()){
		   XmcdaModularTypes value = map.get(key);
		   System.out.println(key+" : "+value);
		}
		
	}

}