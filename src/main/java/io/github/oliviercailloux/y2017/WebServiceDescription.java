package io.github.oliviercailloux.y2017;

import java.io.FileReader;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 * 
 * @author KAKAMA & SAMI
 *
 */
public class WebServiceDescription {
	private  String id;
	XmcdaModularTypes type;
	private static Map<String, XmcdaModularTypes> map =new HashMap<String, XmcdaModularTypes>(); 
	

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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XmcdaModularTypes t = null; 
		WebServiceDescription d  = new WebServiceDescription("id1", t.affineLinearFunction);
		WebServiceDescription.map.put("id2", XmcdaModularTypes.binaryMeasurement);
		System.out.println(WebServiceDescription.map.get("id1"));
		System.out.println(WebServiceDescription.map.get("id2"));
	}

}
