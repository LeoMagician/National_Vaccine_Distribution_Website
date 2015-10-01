package com.leo.model.models;

import com.infrastructure.project.base.model.interfaces.ICUDEable;
import com.infrastructure.project.base.model.models.EnableEntity;

public class OrderItem extends EnableEntity<Integer> implements ICUDEable{
	
//	public OrderItem(Cart order, Vaccine vaccine, int amount) {
//            
//		this.cart = order;
//		this.vaccine = vaccine;
//		this.amount = amount;		
//		vaccine.setAvailability(vaccine.getAvailability()-amount);
//		this.price = vaccine.getPrice() * amount;        
//	}
//	public OrderItem(){
//		
//	}
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
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
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
