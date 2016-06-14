package webSrc.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;








import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import restful.service.PolicyInformationService;
import webSrc.model.Policy;

import javax.ws.rs.core.Response;
@RestController
public class PolicyController {

	public PolicyController() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	PolicyInformationService policyInformationService;
	
	//@RequestMapping(method=GET)
	@RequestMapping(value = "/getPolicy/{policyNumber}" , method = RequestMethod.GET)
	@Produces("application/json")
	public Response /*Policy*/ getPolicyDetails(@PathVariable String policyNumber){
		Policy policy = new Policy();
		policy = policyInformationService.getPolicyDataUsingGet(policyNumber);//2000011
		return /*policy;*/ Response.ok(policy).build();
		
		
	}
	
	//IGNORE AND DELETE
	@RequestMapping(value = "/getPol/{policyNumber}" , method = RequestMethod.GET)
	@Produces("application/json")
	public Response /*Policy*/ getPolicyDetailsblaBla(@PathVariable String policyNumber){
		Policy policy = new Policy();
		policy = policyInformationService.getPolicyDataUsingGet(policyNumber);//2000011
		Response response = Response.ok(policy).header("XYZ", "cheersBhai").build();
//		response.
		return response;
		
		
	}
	
	

}
