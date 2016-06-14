package restful.service.impl;

import restful.service.PolicyInformationService;
import webSrc.model.Policy;

public class PolicyInformationServiceImpl implements PolicyInformationService{

	public PolicyInformationServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Policy getPolicyDataUsingGet(String policyNumber) {
		//String poliyNumberAsString = policyNumber.toString();
		return applicationClient.getPolicyDataOSP(policyNumber);
		
		/*if (poliyNumberAsString.startsWith("1")){
			return applicationClient.getPolicyDataAcmeInc(policyNumber);
		} else {
			return applicationClient.getPolicyDataWayneEnt(policyNumber);
		}*/
		
}

}
