package io.github.oliviercailloux.y2017.jxmcda.controller;

//import java.util.HashMap;
//import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import io.github.oliviercailloux.y2017.jxmcda.entities.Alternative;
//import io.github.oliviercailloux.y2017.jxmcda.entities.Criterion;
//import io.github.oliviercailloux.y2017.jxmcda.entities.Evaluation;
//import io.github.oliviercailloux.y2017.jxmcda.entities.Problem;
import io.github.oliviercailloux.y2017.jxmcda.entities.SetDB1;


@Path("/xmcda")
public class WebService {
	//private static final String String = null;
//		private static Map<String,Alternative> alternatives = new HashMap<String,Alternative>();
//		private static Map<String,Criterion> criteria = new HashMap<String,Criterion>();
//		private static Map<String,Evaluation> evaluations = new HashMap<String,Evaluation>();
//		private static Map<Integer,Problem> Problems = new HashMap<Integer,Problem>();
//		
	SetDB1 setdb;
	
	@POST
	@Path("/add")
	public Response addCriterion(			
			@FormParam("idProblem") int idPlm,
			@FormParam("idCriterion") int idCrit,
			@FormParam("nameCriterion") String nameCrit,
			@FormParam("idAlternative") String idAlt,
			@FormParam("nameAlternative") String nameAlt,
			@FormParam("ValueEvaluation") Double valEval) {
		
		
		setdb=new SetDB1();
		setdb.insertAlternative(idAlt, nameAlt);
		return Response.status(200)
				.entity("Data : "
						+"\n Problem : " + idPlm 
						+"\n Criterion : " + idCrit + ", name : "+ nameCrit
						+"\n Alternative : " + idAlt + ", name : " + nameAlt
						+"\n Evaluation value  : " + valEval ).build();
	}
	
	@Path("/alt")
	public class Servlets {
	
		@Path("/geto")
		@GET
		public String getData() {
			return "HAHA";
		}
		@GET
		@Path("/{id}/getAlternative")
		public Alternative getAlternative(@PathParam("id") String id) {
			Alternative alt = new Alternative();
			alt.setId("99");
			alt.setName("Alternative");
			return alt;
		}
		
//		@GET
//		@Path("/{id}/getCriterion")
//		public Criterion getCriterion(@PathParam("id") int id) {
//			Criterion crit = new Criterion();
//			crit.setId(12);
//			crit.setName("Criterion");
//			return crit;
//		}
		
//		@GET
//		@Path("/{id}/getEvaluation")
//		public Evaluation getEvaluations(@PathParam("id")Alternative Alternative, Criterion Criterion, Double val) {
//			Evaluation eval = new Evaluation();
//			eval.getalt().setId("5");
//			eval.getCrit().setId(3);
//			eval.setVal(12.9);
//			return eval;
//		}
	//	
//		@Path("/addAlternative")
//		@POST
//	    public Response post(Alternative alternative) {
//	        alternatives.put(null, alternative);
//	        return Response.ok(alternative).build();
//	    }
	//	
//		@Path("/addCriterion")
//		@POST
//	    public Response post(Criterion criterion) {
//	        criteria.put(null, criterion);
//	        return Response.ok(criterion).build();
//	    }
	//	
//		@Path("/setCriterion")
//		@PUT
//	    public Response put(Criterion criterion) {
//	        criteria.put(null, criterion);
//	        return Response.ok(criterion).build();
//	    }
	//	
	
		
//			@POST
//		    @Path("list")
//		    public List<Alternative> getAlternatives(String id,String name) {
//		        List<Alternative> alternatives = new ArrayList<Alternative>();
//		        
//		        alternatives.add(new Alternative("ID","NAME"));
//		        alternatives.add(new Alternative("ID","NAME"));
//		        alternatives.add(new Alternative("ID","NAME"));
	//
//		        return alternatives;
//		    }
					 
		 
//		@POST
//	    @Path("/add")
//		public Alternative addAlternative(Alternative alts) {
//			Alternative alternative = new Alternative();
//			if(alternatives.get(alts.getId()) != null){
//				Response.status(0);
//				Response.me("Alternative Already Exists");
//				return Response;
//			}
//			alternatives.put(alts.getId(), alts);
//			Response.setStatus(true);
//			Response.setMessage("Alternative created successfully");
//			return Response;
	//	
	
	}
}