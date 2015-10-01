package com.leo.web.models;

public class VaccineQuotaModel {

	private int id;
	private int quotaId;
	private String vaccineName;
	private String stateName;
	private int quota;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public int getQuota() {
		return quota;
	}
	public void setQuota(int quota) {
		this.quota = quota;
	}
	public String getVaccineName() {
		return vaccineName;
	}
	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}
	public int getQuotaId() {
		return quotaId;
	}
	public void setQuotaId(int quotaId) {
		this.quotaId = quotaId;
	}			
	
}
