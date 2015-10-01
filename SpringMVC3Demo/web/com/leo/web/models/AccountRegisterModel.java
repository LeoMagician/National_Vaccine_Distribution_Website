package com.leo.web.models;

import javax.validation.constraints.AssertTrue;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class AccountRegisterModel {
	@NotEmpty(message="{name.not.empty}")
	private String name;
	@NotEmpty(message="{email.not.empty}")
	@Email(message="{email.not.correct}")
	private String email;
	@NotEmpty(message="{username.not.empty}")
	private String username;
	@Length(min=8, message="{password.length.error}")  
	private String password;
	private String confirmPassword;
	@AssertTrue(message="{agreement.must.agree}")
	private boolean agreement;
	
	public void setName(String name){
		this.name=name;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setConfirmPassword(String confirmPassword){
		this.confirmPassword=confirmPassword;
	}
	public void setAgreement(boolean agreement){
		this.agreement=agreement;
	}
	
	public String getName(){
		return this.name;
	}
	public String getEmail(){
		return this.email;
	}
	public String getUsername(){
		return this.username;
	}
	public String getPassword(){
		return this.password;
	}
	public String getConfirmPassword(){
		return this.confirmPassword;
	}
	public boolean getAgreement(){
		return this.agreement;
	}
}
