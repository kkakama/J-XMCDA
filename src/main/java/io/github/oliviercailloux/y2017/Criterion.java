
	package io.github.oliviercailloux.y2017;
	import javax.json.bind.Jsonb;
	import javax.json.bind.JsonbBuilder;
	import javax.json.bind.JsonbConfig;



	/**
	 * @author Nbencheri2
	 *
	 */
	public class Criterion {

		private int id;
		private String name;

		
		
		// Criterion constructor
		public Criterion(int id, String name) {
			
			this.id = id;
			this.name = name;
			
		}
		
		    
		 // Getter and Setter of the ID and the name   
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		

		@Override 
		public String toString(){
			return "Criterion name :" +this.name+ " , id :" + this.id;
		}
		
		// Create Json and serialize
		public String toJson() {
			Jsonb jsonb = JsonbBuilder.create((new JsonbConfig().withFormatting(true)));
		    String json = jsonb.toJson(this);
			return json;
		
		}
		// Deserialize back
		   public Criterion JsontoCriterion(String CriterionJson) {
		    	Jsonb jsonb = JsonbBuilder.create();
		    	return jsonb.fromJson(CriterionJson, Criterion.class);
		    }
	

}
