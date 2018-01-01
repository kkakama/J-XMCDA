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

/**
 * 
 * @author KAKAMA & SAMI
 *
 */
public class WebServiceDescription {
	private  String id;
	XmcdaModularTypes type;
	private static Map<String, XmcdaModularTypes> map =new HashMap<String, XmcdaModularTypes>(); 
	
	public WebServiceDescription(){
	
	}
	public WebServiceDescription(Map<String, XmcdaModularTypes> m ){
		map = m;
		
	}
	public WebServiceDescription(String id, XmcdaModularTypes type) {
		this.id = id;
		this.type = type;
		map.put(id, type);
		
	}
	/**
	 * This function has in parameters the id of 
	 * the pair and associate a type to it
	 * @param id
	 * 			the id of the pair
	 * @param type
	 * 			the type
	 */
	public void insertPair(String id,XmcdaModularTypes type){
		map.put(id, type);
	}
	public void removeFromMap(String id){
		map.remove(id);
	}
	// getters and setters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public XmcdaModularTypes getType() {
		return type;
	}
	public void setType(XmcdaModularTypes type) {
		this.type = type;
	}
	public  Map<String, XmcdaModularTypes> getMap() {
		return map;
	}
	public  void setMap(Map<String, XmcdaModularTypes> map) {
		WebServiceDescription.map = map;
	}
	/**
	 * With this function we can create a Json File saved in the project repository
	 * @param map
	 * 	
	 */
	public void encodageJson(Map<String,XmcdaModularTypes> map){	
		JsonObjectBuilder buil =Json.createObjectBuilder();
		Set keys = map.keySet();
		Iterator it = keys.iterator();
		while (it.hasNext()){
		   String key = (String) it.next(); 
		   XmcdaModularTypes valeur = map.get(key); 
		   buil.add(key, String.valueOf(valeur));
		}
		JsonObject mod = buil.build();
		StringWriter stWriter = new StringWriter();
		JsonWriter jsonWriter = Json.createWriter(stWriter);
		jsonWriter.writeObject(mod);
		jsonWriter.close();
		 
		String jsonData = stWriter.toString();
		try {
			FileWriter f = new FileWriter("WebServiceDescr.json");
			f.write(jsonData);
			f.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(jsonData);
		
	}
	/**
	 * With this function we can read Json File's content and stock it in our Map
	 * @param filename
	 * 				correspond to json file's name
	 * @return
	 */
	public Map<String,XmcdaModularTypes> decodageJson(String filename){
		Map<String,XmcdaModularTypes> jsonMap = new HashMap<String, XmcdaModularTypes>();
		JsonReader reader;
		String jsondata="";
		try {
			reader = Json.createReader(new FileReader(filename));
			JsonStructure jsonst = reader.read();
			jsondata= jsonst.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		final JsonParser parser = Json.createParser(new StringReader(jsondata));
	    String key = null;
	    XmcdaModularTypes value = null;
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
		        jsonMap.put(key, value);
	    }
	        parser.close();
		return jsonMap;	
		
	}
	public void showMap(Map<String,XmcdaModularTypes> m){
		Set keys = map.keySet();
		Iterator it = keys.iterator();
		while (it.hasNext()){
		   String key = (String) it.next(); 
		   XmcdaModularTypes value = map.get(key);
		   System.out.println(key+" : "+value);
		}
		
	}
	public static void main(String[] args) {

		XmcdaModularTypes t = null; 
		WebServiceDescription d  = new WebServiceDescription();
		WebServiceDescription.map.put("id2", XmcdaModularTypes.binaryMeasurement);
		WebServiceDescription.map.put("id3", XmcdaModularTypes.binaryMeasurement);
		d.encodageJson(WebServiceDescription.map);
		Map<String, XmcdaModularTypes> mappp=d.decodageJson("WebServiceDescr.json");
		d.showMap(mappp);
	}

}
