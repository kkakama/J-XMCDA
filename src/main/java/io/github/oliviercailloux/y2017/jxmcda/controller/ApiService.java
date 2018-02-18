package io.github.oliviercailloux.y2017.jxmcda.controller;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import io.github.oliviercailloux.y2017.jxmcda.entities.ProblemModel;

public final class ApiService {

	public static void sendData(ProblemModel model) {
		System.out.println("call api...: " + model.getProblemId());
		String JSON_STRING = "?";
		
		StringEntity requestEntity = new StringEntity(
			    JSON_STRING,
			    ContentType.APPLICATION_JSON);
		
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPost httppost = new HttpPost("http://localhost/");
			httppost.setEntity(requestEntity);
			HttpResponse response = httpclient.execute(httppost);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
