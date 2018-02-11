package io.github.oliviercailloux.y2017;

	import javax.xml.bind.annotation.XmlRootElement;

	/* I create a bean model; 
	 * Response for sending response to client systems. 
	 * I will be sending XML response, 
	 * the beans will be annotated with @XmlRootElement
	 */
	@XmlRootElement
	public class Response {

		private boolean status;
		private String message;

		public boolean isStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}
