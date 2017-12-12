package io.github.oliviercailloux.y2017;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Alternative {
	private String id;
	private String name;
	private static ArrayList<Alternative> list_alternatives;
	
	
	/**
	 * Construcor of alternative class containing the folowing parameters
	 * @param id
	 * @param name
	 */
	public Alternative(String id, String name) {
		this.id = id;
		this.name = name;
	}

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @param file
	 * 	name of the file of alternatives list
	 * @return
	 * list of alternatives in the correct format (ID, NAME)
	 */

	public static ArrayList<Alternative> readJsonAlternatives(String file){
		ArrayList<Alternative> alternatives_list=new ArrayList<Alternative>();
		Alternative alt;
		String name="";
		String id="";
        JSONParser parser = new JSONParser();
        try {
       	 
            Object obj = parser.parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray alts = (JSONArray) jsonObject.get("alternatives");
            //System.out.println(alts.toString());
            Iterator i = alts.iterator();
            //JSONObject alts_att = (JSONObject) i.next();
            while(i.hasNext()){
            	JSONObject alts_att = (JSONObject) i.next();
            	name = (String)alts_att.get("name");
            	id= (String)alts_att.get("id");
            	alt=new Alternative(id,name);
            	alternatives_list.add(alt);
            }
            
	
	}
        catch(Exception e){
        	}
        return alternatives_list;

        
   }
	public static void createAlternativeList() {
		list_alternatives = new ArrayList<Alternative>();
    }

    public static void addAlternativeToList(Alternative Alternative) {
    	list_alternatives.add(Alternative);
    }

    public static void clearAlternativeList() {
    	list_alternatives.clear();
    }

    public static ArrayList<Alternative> getAlternativeList() {
         return list_alternatives;
    }

/*	public static void main(String[] args) {
		
		ArrayList<Alternative> l=new ArrayList<Alternative>();
		l=Alternative.readJsonAlternatives("alts.json");
		for(Alternative a:l){
			System.out.println(a.id+" "+a.name);
		} */
		
		
		


}