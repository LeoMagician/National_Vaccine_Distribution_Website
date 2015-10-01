package com.leo.service.models;

import javax.validation.constraints.NotNull;

public class VaccineCart {
	@NotNull(message="{vaccineId.not.null}")
	private int id;
	@NotNull(message="{number.not.null}")
	private int number;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
}
