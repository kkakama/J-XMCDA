package io.github.oliviercailloux.y2017;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.bind.*;

import com.sun.jersey.server.wadl.generators.ObjectFactory;


/**
 * 
 * @author SAMI & KAKAMA
 *
 */
public class ObjectXml {
	
	// Marshalling Alternative 
	public void marshalling(Alternative alt){
		
		JAXBContext jc;
		try {
			JAXBContext context = JAXBContext.newInstance(Alternative.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			//m.marshal(alt, System.out);

			try {
				m.marshal(alt, new FileOutputStream("alternative.xml"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	// Marshalling Alternative List
	public void marshalling(Alternatives alt){
		
		JAXBContext jc;
		try {
			JAXBContext context = JAXBContext.newInstance(Alternatives.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			//m.marshal(alt,System.out);
			try {
				m.marshal(alt, new FileOutputStream("all_alternatives.xml"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	// Marshalling Criteria
	public void marshalling(Criterion crit){
			
			JAXBContext jc;
			try {
				JAXBContext context = JAXBContext.newInstance(Criterion.class);
				Marshaller m = context.createMarshaller();
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				//m.marshal(crit, System.out);
	
				try {
					m.marshal(crit, new FileOutputStream("criteria.xml"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		// Marshalling Criterion 
		public void marshalling(CriteriaList crits){
		
		JAXBContext jc;
		try {
		
			JAXBContext context = JAXBContext.newInstance(CriteriaList.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			//m.marshal(crits,System.out);
			try {
				m.marshal(crits, new FileOutputStream("criterion.xml"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
		// Marshalling Evaluation 
	public void marshalling(Evaluation eval){
			
			JAXBContext jc;
			try {
				JAXBContext context = JAXBContext.newInstance(Evaluation.class);
				Marshaller m = context.createMarshaller();
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				//m.marshal(eval, System.out);
	
				try {
					m.marshal(eval, new FileOutputStream("evaluation.xml"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}

	public void unmarshalling(String fname){
		
		switch (fname){
		case "all_alternatives.xml":
		    //We had written this file in marshalling example
		    Alternatives alternatives;
			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(Alternatives.class);
			    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				alternatives = (Alternatives) jaxbUnmarshaller.unmarshal( new FileInputStream("all_alternatives.xml") );
				 for(Alternative alt : alternatives.getAlternatives())
				    {
				        System.out.println(alt.getId());
				        System.out.println(alt.getName());
				    }
				} catch (JAXBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}break;
			
			case "criteria.xml":
				   Criterion crit;
					try {
						JAXBContext jaxbContext = JAXBContext.newInstance(Criterion.class);
					    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
						crit = (Criterion) jaxbUnmarshaller.unmarshal( new FileInputStream("criteria.xml") );
						} catch (JAXBException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				break;
		     
			case "qlqchose":
				System.out.println("ss");break;
			default:
					System.out.println("ok");
			
		
	}
	}
	
}
