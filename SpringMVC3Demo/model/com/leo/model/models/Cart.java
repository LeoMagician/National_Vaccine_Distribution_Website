package com.leo.model.models;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.infrastructure.project.base.model.interfaces.ICUDEable;
import com.infrastructure.project.base.model.models.EnableEntity;

public class Cart extends EnableEntity<Integer> implements ICUDEable{
	
	private float priceTotal;
	private Calendar date;	
	private Set<OrderItem> orderItems = new HashSet();
	private boolean phdEnable;
    private boolean cdcEnable;
    private boolean manuEnable;
    private boolean disEnable;
    private boolean dcEnable;
    private boolean hosEnable;
    private String status;	
    private Account account;
    private String accountId;
    private DC dc;
	
	public float getPriceTotal() {
		return priceTotal;
	}
	public void setPriceTotal(float priceTotal) {
		this.priceTotal = priceTotal;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public boolean isPhdEnable() {
		return phdEnable;
	}
	public void setPhdEnable(boolean phdEnable) {
		this.phdEnable = phdEnable;
	}
	public boolean isCdcEnable() {
		return cdcEnable;
	}
	public void setCdcEnable(boolean cdcEnable) {
		this.cdcEnable = cdcEnable;
	}
	public boolean isManuEnable() {
		return manuEnable;
	}
	public void setManuEnable(boolean manuEnable) {
		this.manuEnable = manuEnable;
	}
	public boolean isDisEnable() {
		return disEnable;
	}
	public void setDisEnable(boolean disEnable) {
		this.disEnable = disEnable;
	}
	public boolean isDcEnable() {
		return dcEnable;
	}
	public void setDcEnable(boolean dcEnable) {
		this.dcEnable = dcEnable;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public DC getDc() {
		return dc;
	}
	public void setDc(DC dc) {
		this.dc = dc;
	}
	public boolean isHosEnable() {
		return hosEnable;
	}
	public void setHosEnable(boolean hosEnable) {
		this.hosEnable = hosEnable;
	}			
	
//	public void addProduct(Vaccine p, int amount) {
//		OrderItem orderItem = new OrderItem(this, p, amount);
//		this.priceTotal = this.priceTotal + p.getPrice() * amount;
//		this.orderItems.add(orderItem);
//	}
}
