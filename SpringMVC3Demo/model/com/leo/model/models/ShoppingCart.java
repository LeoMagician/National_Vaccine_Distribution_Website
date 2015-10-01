package com.leo.model.models;

import com.infrastructure.project.base.model.interfaces.ICUDEable;
import com.infrastructure.project.base.model.models.EnableEntity;

public class ShoppingCart extends EnableEntity<Integer> implements ICUDEable{
	
	
	private Vaccine vaccine;
	private Cart cart;
	private String cartId;
	private String vaccineId;
    private float price;
    private int amount;        

	public Vaccine getVaccine() {
		return vaccine;
	}
	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}	
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public String getVaccineId() {
		return vaccineId;
	}
	public void setVaccineId(String vaccineId) {
		this.vaccineId = vaccineId;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
