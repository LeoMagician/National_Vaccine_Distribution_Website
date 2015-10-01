package com.leo.web.models.extension;

import java.util.Calendar;
import java.util.Date;

import com.leo.model.models.Cart;
import com.leo.web.models.OrderEditModel;

public class OrderModelExtension {
	
	public static Cart toCart(OrderEditModel orderEditModel){
//		int size = orderEditModel.getOrderItemId().size();
		Cart cart = new Cart();
		cart.setId(orderEditModel.getId());	
		cart.setDate(Calendar.getInstance());
		cart.setPriceTotal(orderEditModel.getPriceTotal());
		return cart;
	}
	
	
	
}
