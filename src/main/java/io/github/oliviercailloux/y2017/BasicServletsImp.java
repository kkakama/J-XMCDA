package io.github.oliviercailloux.y2017;

	import java.util.HashMap;
    import java.util.Map;
	import java.util.Set;

	import javax.ws.rs.Consumes;
	import javax.ws.rs.GET;
	import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
	import javax.ws.rs.PathParam;
	import javax.ws.rs.Produces;
	import javax.ws.rs.core.MediaType;

    import io.github.oliviercailloux.y2017.BasicServlets;

    import io.github.oliviercailloux.y2017.Alternative;
	import io.github.oliviercailloux.y2017.Criterion;
	import io.github.oliviercailloux.y2017.Evaluation;
	import io.github.oliviercailloux.y2017.Response;

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
		@POST
	    @Path("/add")
		public Response addAlternative(Alternative alt) {
			Response response = new Response();
			if(alternatives.get(alt.getId()) != null){
				response.setStatus(false);
				response.setMessage("Alternative Already Exists");
				return response;
			}
			alternatives.put(alt.getId(), alt);
			response.setStatus(true);
			response.setMessage("Alternative created successfully");
			return response;
		}
		
		@Override
		@POST
	    @Path("/add")
		public Response addCriterion(Criterion crit) {
			Response response = new Response();
			if(criteria.get(crit.getId()) != null){
				response.setStatus(false);
				response.setMessage("Criterion Already Exists");
				return response;
			}
			criteria.put(crit.getId(), crit);
			response.setStatus(true);
			response.setMessage("Criterion created successfully");
			return response;
		}
		
		@Override
		@PUT
	    @Path("/{id}/set")
		public Response setEvaluation(@PathParam("id") int id) {
			Response response = new Response();
			if(evaluations.get(id) == null){
				response.setStatus(false);
				response.setMessage("Evaluation Doesn't Exists");
				return response;
			}
			evaluations.keySet();
			response.setStatus(true);
			response.setMessage("Evaluation updated successfully");
			return response;
		}
		
	}