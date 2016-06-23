package restful.service.impl;

import org.apache.log4j.Logger;

import restful.service.AccountInformationService;
import webSrc.controller.AccountController;
import webSrc.model.Account;

public class AccountInformationServiceImpl implements AccountInformationService{
	private static final Logger logger = Logger.getLogger(AccountInformationServiceImpl.class); 
	public AccountInformationServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Account getAccountDetails(String accountId) {
		return accountApplicationClient.getAccountDetails(accountId);
	}

	@Override
	public void updateAccountDetails(Account account) {
		accountApplicationClient.updateAccountDetails(account);
		
	}

}
