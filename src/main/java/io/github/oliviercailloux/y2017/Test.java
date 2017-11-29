package io.github.oliviercailloux.y2017;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;


public class Test {

	public static void main(String[] args) throws JSONException {

		String xmlString = "<pair>\r\n" + 
				"<initial>\r\n" + 
				"<alternativeID>a01</alternativeID>\r\n" + 
				"</initial>\r\n" + 
				"<terminal>\r\n" + 
				"<alternativeID>a01</alternativeID>\r\n" + 
				"</terminal>\r\n" + 
				"<value>\r\n" + 
				"<real>0.0</real>\r\n" + 
				"</value>\r\n" + 
				"</pair>";

		JSONObject jsonObject = XML.toJSONObject(xmlString);

		System.out.println(jsonObject);
	}

}



