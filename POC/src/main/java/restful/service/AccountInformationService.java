package restful.service;

import webSrc.model.Account;

public interface AccountInformationService {

	
public Account getAccountDetails (String accountName);
public void updateAccountDetails (Account account);
}
