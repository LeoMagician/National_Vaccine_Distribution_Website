package com.leo.model.models;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import com.infrastructure.project.base.model.interfaces.ICUDEable;
import com.infrastructure.project.base.model.models.EnableEntity;

public class Account extends EnableEntity<Integer> implements ICUDEable {

	private String email;
	private String username;
	private String password;
	private Calendar registerTime;
	private Role role;
	private Organization organization;
	private Set<Cart> carts = new HashSet();
	private Hospital hospital;
	private String hospitalId;
//	private DC dc;
	
	public void setEmail(String email){
		this.email=email;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setRegisterTime(Calendar registerTime){
		this.registerTime=registerTime;
	}
	public void setRole(Role role){
		this.role=role;
	}
	public void setOrganization(Organization organization){
		this.organization=organization;
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
	public Calendar getRegisterTime(){
		return this.registerTime;
	}
	public Role getRole(){
		return this.role;
	}	
	public Organization getOrganization(){
		return this.organization;
	}
	public Set<Cart> getCarts() {
		return carts;
	}
	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}
	
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public String getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
//	public DC getDc() {
//		return dc;
//	}
//	public void setDc(DC dc) {
//		this.dc = dc;
//	}	
	
}
