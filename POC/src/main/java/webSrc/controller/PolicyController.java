package webSrc.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;










import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import restful.service.PolicyInformationService;
import webSrc.model.Policy;

import javax.ws.rs.core.Response;
@RestController
public class PolicyController {
	private static final Logger logger = Logger.getLogger(PolicyController.class);
	public PolicyController() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	PolicyInformationService policyInformationService;
	
	@RequestMapping(value = "/getPolicy/{policyNumber}" , method = RequestMethod.GET)
	@Produces("application/json")
	public Response /*Policy*/ getPolicyDetails(@PathVariable String policyNumber){
		logger.info("Intercepted policy Number is: " + policyNumber);
		Policy policy = new Policy();
		policy = policyInformationService.getPolicyDataUsingGet(policyNumber);//2000011
		return /*policy;*/ Response.ok(policy).build();
		
		
	}
	
	//IGNORE AND DELETE
	@RequestMapping(value = "/getPol/{policyNumber}" , method = RequestMethod.GET)
	@Produces("application/json")
	public Response /*Policy*/ getPolicyDetailsWithMetaData(@PathVariable String policyNumber){
		Policy policy = new Policy();
		policy = policyInformationService.getPolicyDataUsingGet(policyNumber);//2000011
		Response response = Response.ok(policy).header("TELL MALOY WHAT YOU WANT", "IT WILL BE SENT IN METADATA LIKE THIS").build();
//		response.
		return response;
		
		
	}
	
	//IGNORE AND DELETE
		@RequestMapping(value = "/updatePolicy" , method = RequestMethod.POST)
		@Produces("application/json")
		public Response /*Policy*/ updatePolicyDetails(@RequestBody Policy policyUpdateRequest){
			Policy policy = new Policy();
			policyInformationService.updatePolicyDetails(policyUpdateRequest);//2000011
			Response response = Response.ok().header("TELL MALOY WHAT YOU WANT IN POST RESPONSE HEADER", "IT WILL BE SENT IN METADATA LIKE THIS").build();
//			response.
			return response;
			
			
		}

}
