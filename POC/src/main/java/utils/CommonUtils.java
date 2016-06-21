/**
 * 
 */
package utils;
import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * @author 234077
 *
 */
public class CommonUtils {

	/**
	 * 
	 */
	public static String createWebServiceURL(String policyNumber){
		String formedURL = "";
		String iPAddress = getIpAddress();
		//temporary
		iPAddress = "54.229.52.191";
		formedURL =  "http://"+iPAddress + ":" + Constants.CONNECTING_PORT_FUSE +"/cxf/client/status/policy/" + policyNumber;
		return formedURL;
	}
	public static String getIpAddress() {
		InetAddress iAddress;
		String systemIp = "";
		try {
			iAddress = InetAddress.getLocalHost();

			systemIp = iAddress.getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return systemIp;
	}
	public CommonUtils() {
	}

}
