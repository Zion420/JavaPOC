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
	public static String createWebServiceURL(String selectionCriteria, String resourceName, String serviceType){
		
		String formedURL = "";
		String iPAddress = getIpAddress();
		//temporary
		iPAddress = "54.229.107.3";//"54.229.52.191";
		if(Constants.RESOURCE_TYPE_POLICY.equalsIgnoreCase(resourceName)){
			if(Constants.SERVICE_TYPE_GET.equalsIgnoreCase(serviceType)){
				
				formedURL =  "http://"+iPAddress + ":" + Constants.CONNECTING_PORT_FUSE +"/cxf/client/status/policy/" + selectionCriteria;
				
			} else if (Constants.SERVICE_TYPE_POST.equalsIgnoreCase(serviceType)){
				formedURL = "http://"+iPAddress + ":" + Constants.CONNECTING_PORT_FUSE +"/cxf/client/status/update/";
			} else {
				////PROVISON TO THROW ERROR
			}
			
			
		} else if(Constants.RESOURCE_TYPE_ACCOUNT.equalsIgnoreCase(resourceName)){
			if(Constants.SERVICE_TYPE_GET.equalsIgnoreCase(serviceType)){
				formedURL =  "http://"+iPAddress + ":" + Constants.CONNECTING_PORT_FUSE +"/cxf/sugar/account/details/" + selectionCriteria; 
				
			} else if (Constants.SERVICE_TYPE_POST.equalsIgnoreCase(serviceType)){
				formedURL = "http://"+iPAddress + ":" + Constants.CONNECTING_PORT_FUSE +"/cxf/sugar/account/details/update/";
			} else {
				////PROVISON TO THROW ERROR
			}
			
			
		} else {
			//PROVISON TO THROW ERROR
		}
		
		
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
