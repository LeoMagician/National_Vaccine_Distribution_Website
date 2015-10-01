package com.leo.model.models;

import java.util.HashSet;
import java.util.Set;

import com.infrastructure.project.base.model.interfaces.ICUDEable;
import com.infrastructure.project.base.model.models.EnableEntity;

public class State extends EnableEntity<Integer> implements ICUDEable{
	
	private int population;
	private int quota;
	private Set<Quota> quotas = new HashSet();
	
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public int getQuota() {
		return quota;
	}
	public void setQuota(int quota) {
		this.quota = quota;
	}
	public Set<Quota> getQuotas() {
		return quotas;
	}
	public void setQuotas(Set<Quota> quotas) {
		this.quotas = quotas;
	}
	
	
	
	
}
