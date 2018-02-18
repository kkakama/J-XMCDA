package io.github.oliviercailloux.y2017.jxmcda.entities;

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
 * @author SAMI & KAKAMA
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
	
	public void displayMap(Map<String,XmcdaModularTypes> map){
		for(String key:map.keySet()){
		   XmcdaModularTypes value = map.get(key);
		   System.out.println(key+" : "+value);
		}
		
	}

}