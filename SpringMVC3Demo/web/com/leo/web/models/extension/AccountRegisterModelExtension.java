package com.leo.web.models.extension;

import com.leo.model.models.Account;
import com.leo.web.models.AccountRegisterModel;

public class AccountRegisterModelExtension {
	public static Account toAccount(AccountRegisterModel registerModel){
		Account ret=new Account();
		ret.setName(registerModel.getName());
		ret.setEmail(registerModel.getEmail());
		ret.setUsername(registerModel.getUsername());
		ret.setPassword(registerModel.getPassword());
		
		return ret;
	}
}
