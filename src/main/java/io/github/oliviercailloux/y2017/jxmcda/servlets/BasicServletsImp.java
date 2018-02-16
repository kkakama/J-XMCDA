package io.github.oliviercailloux.y2017.jxmcda.servlets;

	import java.util.HashMap;
    import java.util.Map;

	import javax.ws.rs.Consumes;
	import javax.ws.rs.GET;
	import javax.ws.rs.POST;
	import javax.ws.rs.PUT;
	import javax.ws.rs.Path;
	import javax.ws.rs.PathParam;
	import javax.ws.rs.Produces;
	import javax.ws.rs.core.MediaType;

import io.github.oliviercailloux.y2017.jxmcda.entities.Alternative;
import io.github.oliviercailloux.y2017.jxmcda.entities.Criterion;
import io.github.oliviercailloux.y2017.jxmcda.entities.Evaluation;

	/*
	 * Some of the important JAX-RS annotations used below :
	 * @Path: used to specify the relative path of class and methods.
	 * @GET, @PUT, @POST : used to specify the HTTP request type for a method.
	 * @Produces, @Consumes: used to specify the request and response types.
	 * @PathParam: used to bind the method parameter to path value by parsing it.
	 */
	@Path("/service")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	
	public class BasicServletsImp  implements BasicServlets{
		private static Map<String,Alternative> alternatives = new HashMap<String,Alternative>();
		private static Map<Integer,Criterion> criteria = new HashMap<Integer,Criterion>();
		private static Map<String,Evaluation> evaluations = new HashMap<String,Evaluation>();

		@Override
		@GET
		@Path("/{id}/get")
		public Alternative getAlternative(@PathParam("id") String id) {
			return alternatives.get(id);
		}
		
		@Override
		@GET
		@Path("/{id}/get")
		public Criterion getCriterion(@PathParam("id") int id) {
			return criteria.get(id);
		}
		
		@Override
		@GET
		@Path("/{id}/get")
		public Evaluation getEvaluation(@PathParam("id") int id) {
			return evaluations.get("id");
		}
		
		@Override
		public Evaluation setEvaluations(int id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Alternative addAlternative(Alternative alt) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Criterion addCriterion(Criterion crit) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}