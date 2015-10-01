package com.leo.web.models.extension;

import com.leo.model.models.OrderItem;
import com.leo.model.models.ShoppingCart;
import com.leo.model.models.Vaccine;
import com.leo.web.models.CartEditModel;

public class CartModelExtension {
	
	public static OrderItem toOrderItem(CartEditModel editModel){
		
		OrderItem oi = new OrderItem();
		oi.setId(editModel.getId());
		oi.setName(editModel.getName());
		oi.setPrice(editModel.getPrice());
		oi.setAmount(editModel.getNumber());
		return oi;
	}
	
	public static CartEditModel toCartEdit(Vaccine vaccine){
		CartEditModel editModel = new CartEditModel();
		editModel.setName(vaccine.getName());
		editModel.setVaccineId(vaccine.getId());
		editModel.setPrice(vaccine.getPrice());		
		return editModel;
	}
	
	public static ShoppingCart toShoppingCart(CartEditModel editModel){
		
		ShoppingCart oi = new ShoppingCart();
		oi.setId(editModel.getId());
		oi.setName(editModel.getName());
		oi.setPrice(editModel.getPrice());
		oi.setAmount(editModel.getNumber());
		return oi;
	}
}
