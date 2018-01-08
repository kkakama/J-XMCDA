import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public final class ApiService {

	public static void sendData(ProblemModel model) {
		System.out.println("call api...: " + model.getProblemId());

		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPost httppost = new HttpPost("http://localhost/");
			CloseableHttpResponse response = httpclient.execute(httppost);
			try {

			} finally {
				response.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
