/**
 * 
 */
package restful.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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

	public Policy getPolicyDataOSP(String policyNumber) {
		
		String url = "http://01hw561672:8183/cxf/client/status/policy/" + policyNumber;
		String resposeAsString = "";
		
	/*	
		//SET ONE
		HttpGet httpGet = new HttpGet(url);
		//httpGet.setEntity(multipartEntity);
		HttpClient defaultHttpClient = new DefaultHttpClient();
		HttpResponse execute = null;
		try {
			execute = defaultHttpClient.execute(httpGet);
		HttpEntity entity = execute.getEntity();
		JSONObject parse = (JSONObject) JSONValue.parse(new InputStreamReader(
		entity.getContent()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//SET TWO
*/		try{
		URL connectingURL = new URL(url);
		 HttpURLConnection conn =
			      (HttpURLConnection) connectingURL.openConnection();
		  if (conn.getResponseCode() != 200) {
		    throw new IOException(conn.getResponseMessage());
		  }
		  // Buffer the result into a string
		  BufferedReader rd = new BufferedReader(
		      new InputStreamReader(conn.getInputStream()));
		  StringBuilder sb = new StringBuilder();
		  String line;
		  while ((line = rd.readLine()) != null) {
		    sb.append(line);
		  }
		  rd.close();
		  conn.disconnect();
		  resposeAsString = sb.toString();
		} catch (Exception e){
			e.printStackTrace();
		}
	return JsonToPojoConverter.convertFromJson(resposeAsString, Policy.class);
		
		
		
	}
/*
	public Policy getPolicyDataWayneEnt(Integer policyNumber) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
