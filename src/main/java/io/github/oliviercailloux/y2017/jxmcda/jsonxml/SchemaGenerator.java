package io.github.oliviercailloux.y2017.jxmcda.jsonxml;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.SchemaOutputResolver;

import io.github.oliviercailloux.y2017.jxmcda.entities.WebServiceDescription;

/**
 * 
 * @author Sami & Noufissa
 *
 */
public class SchemaGenerator {
	
public void marshalling(WebServiceDescription web) throws IOException{
		
		try {
		
			JAXBContext context = JAXBContext.newInstance(WebServiceDescription.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			SchemaOutputResolver sor = new MySchemaOutputResolver();
			context.generateSchema(sor);
		} catch (JAXBException e) {
			e.printStackTrace();
		}	
	}

}
