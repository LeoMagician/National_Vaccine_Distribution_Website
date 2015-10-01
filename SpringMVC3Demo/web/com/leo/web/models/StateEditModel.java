package com.leo.web.models;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

public class StateEditModel {

	private Integer id;
	@NotEmpty(message="{name.not.empty}")
	private String name;	
	@NotNull(message="{population.not.null}")
	private int population;
	
	public void setId(Integer id){
		this.id=id;
	}
	public void setName(String name){
		this.name=name;
	}	
	
	public Integer getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	
}
