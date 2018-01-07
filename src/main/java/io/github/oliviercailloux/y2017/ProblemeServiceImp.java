package io.github.oliviercailloux.y2017;

	import java.util.HashMap;
    import java.util.Map;
	import java.util.Set;

	import javax.ws.rs.Consumes;
	import javax.ws.rs.GET;
	import javax.ws.rs.POST;
	import javax.ws.rs.Path;
	import javax.ws.rs.PathParam;
	import javax.ws.rs.Produces;
	import javax.ws.rs.core.MediaType;

    import io.github.oliviercailloux.y2017.ProblemeService;

    import io.github.oliviercailloux.y2017.Alternative;
	import io.github.oliviercailloux.y2017.Criterion;
	import io.github.oliviercailloux.y2017.Evaluation;
	import io.github.oliviercailloux.y2017.Response;

	@Path("/service")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	
	//public class ProblemeServiceImp implements ProblemeService {
	public class ProblemeServiceImp  {
		private static Map<Integer,Alternative> alternatives = new HashMap<Integer,Alternative>();
		private static Map<Integer,Criterion> criteria = new HashMap<Integer,Criterion>();
		private static Map<Integer,Evaluation> evaluations = new HashMap<Integer,Evaluation>();

		@GET
		@Path("/{id}/getAlternative")
		public Alternative getAlternative(@PathParam("id") int id) {
			Alternative alt = new Alternative();
			alt.setId(id);
			return alt;
		}
		@GET
		@Path("/{id}/getCriterion")
		public Criterion getCriterion(@PathParam("id")int id) {
			Criterion crit = new Criterion();
			crit.setId(id);
			return crit;
		}
		@GET
		@Path("/{id}/getEvaluations")
		public Evaluation getEvaluations(@PathParam("id")int id) {
			Evaluation eval= new Evaluation();
			eval.setId(id);
			return eval;
		}
		//@Override
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
		//@Override
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
		//@Override
		@POST
	    @Path("/put")
		public Response setEvaluation(Evaluation eval) {
			Response response = new Response();
			evaluations.put(eval.getId(), eval);
			response.setStatus(true);
			response.setMessage("Evaluation created successfully");
			return response;
		}
}
