package restful.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
import webSrc.model.Account;
import webSrc.model.Policy;

public class AccountApplicationClient {

	public AccountApplicationClient() {
		// TODO Auto-generated constructor stub
	}
	private static final Logger logger = Logger
			.getLogger(AccountApplicationClient.class);
	public Account getAccountDetails(String accountId) {
		// "http://01hw561672:8182/cxf/client/status/policy/2000011";
		String url = CommonUtils.createWebServiceURL(accountId,
				Constants.RESOURCE_TYPE_ACCOUNT, Constants.SERVICE_TYPE_GET);
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
				Account.class);

	}
	public void updateAccountDetails(Account account) {
		try {

			String input = JsonToPojoConverter.convertToJson(account);
			String url = CommonUtils.createWebServiceURL(
					account.getName(), Constants.RESOURCE_TYPE_ACCOUNT,
					Constants.SERVICE_TYPE_POST);
			logger.info("WebServiceURL triggered for POST request is: " + url);
			HttpClient httpClient = new DefaultHttpClient();

			// http://01hw561672:8182/cxf/client/status/update/
			HttpPost request = new HttpPost(url);
			StringEntity params = new StringEntity(input);
			request.addHeader("content-type", "application/json");
			request.addHeader("Accept", "application/json");
			request.setEntity(params);
			HttpResponse response = httpClient.execute(request);

			// MALOY : PLAY WITH REPONSE HERE.

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
