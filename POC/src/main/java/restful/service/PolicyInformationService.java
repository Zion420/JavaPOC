/**
 * 
 */
package restful.service;

import restful.client.PolicyApplicationClient;
import webSrc.model.Policy;

/**
 * @author 234077
 *
 */
public interface PolicyInformationService {
	PolicyApplicationClient applicationClient = new  PolicyApplicationClient();

	
public Policy getPolicyDataUsingGet(String policyNumber);

public void updatePolicyDetails(Policy policy);
}
