package restful.service;

import restful.client.AccountApplicationClient;
import webSrc.model.Account;

public interface AccountInformationService {

	AccountApplicationClient accountApplicationClient = new  AccountApplicationClient();	
public Account getAccountDetails (String accountId);
public void updateAccountDetails (Account account);
}
