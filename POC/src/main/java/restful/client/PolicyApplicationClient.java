/**
 * 
 */
package restful.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

import utils.CommonUtils;
import utils.Constants;
import utils.JsonToPojoConverter;
import webSrc.model.Policy;

/*
 * TO BE USED WITH SET 1
 import org.apache.http.HttpEntity;
 import org.apache.http.HttpResponse;
 import org.apache.http.client.ClientProtocolException;
 import org.apache.http.client.HttpClient;
 import org.apache.http.client.methods.HttpPost;
 import org.apache.http.client.methods.HttpGet;
 import org.json.simple.JSONObject;
 import org.json.simple.JSONValue;*/

/**
 * @author 234077
 * 
 */
public class PolicyApplicationClient {

	/**
	 * 
	 */
	public PolicyApplicationClient() {
		// TODO Auto-generated constructor stub
	}

	private static final Logger logger = Logger
			.getLogger(PolicyApplicationClient.class);

	public Policy getPolicyDataOSP(String policyNumber) {
		// "http://01hw561672:8182/cxf/client/status/policy/2000011";
		String url = CommonUtils.createWebServiceURL(policyNumber,
				Constants.RESOURCE_TYPE_POLICY, Constants.SERVICE_TYPE_GET);
		logger.info("WebServiceURL triggered is: " + url);
		String resposeAsString = "";
		try {
			URL connectingURL = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) connectingURL
					.openConnection();
			if (conn.getResponseCode() != 200) {
				throw new IOException(conn.getResponseMessage());
			}
			// Buffer the result into a string
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			conn.disconnect();
			resposeAsString = sb.toString();
			logger.info("Json response recived: " + resposeAsString);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in doing the web service CALL:", e);
		}
		return JsonToPojoConverter.convertFromJson(resposeAsString,
				Policy.class);

	}

	public void updatePolicyDetailsOSP(Policy policy) {
		try {

			String input = JsonToPojoConverter.convertToJson(policy);
			String url = CommonUtils.createWebServiceURL(
					policy.getPolicyNumber(), Constants.RESOURCE_TYPE_POLICY,
					Constants.SERVICE_TYPE_POST);
			logger.info("WebServiceURL triggered for POST request is: " + url);
			HttpClient httpClient = new DefaultHttpClient();

			// http://01hw561672:8182/cxf/client/status/update/
			HttpPost request = new HttpPost(url);
			StringEntity params = new StringEntity(input);
			logger.info("Input params created are: " + request);
			request.addHeader("content-type", "application/json");
			request.addHeader("Accept", "application/json");
			request.setEntity(params);
			HttpResponse response = httpClient.execute(request);
			logger.info("Reponse of the WS: " + response);
			// MALOY : PLAY WITH REPONSE HERE.

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
