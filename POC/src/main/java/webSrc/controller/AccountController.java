package webSrc.controller;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import restful.service.AccountInformationService;
import webSrc.model.Account;

@RestController
public class AccountController {
	private static final Logger logger = Logger.getLogger(AccountController.class);
	public AccountController() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	AccountInformationService acountInformationService;
	
	@RequestMapping(value = "/getAccount/{accountName}" , method = RequestMethod.GET)
	@Produces("application/json")
	public Response getAccountDetails(@PathVariable String accountName){
		logger.info("Intercepted AccountName is : " + accountName);
		Account account = new Account();
		account = acountInformationService.getAccountDetails(accountName);
		return  Response.ok(account).build();
		
	}
	
	@RequestMapping(value = "/updateAccount" , method = RequestMethod.POST)
	@Produces("application/json")
	public Response  updateAccountDetails(@RequestBody Account account){
		logger.info("Intercepted AccountDetails are : " + account);
		return null;
		
	}

}
