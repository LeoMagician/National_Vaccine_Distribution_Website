package com.leo.web.models.extension;

import com.leo.model.models.Inventory;
import com.leo.model.models.OrderItem;

public class RecieveModelExtension {
	
	public static Inventory toInventory(OrderItem oi){
		Inventory inv = new Inventory();
		
		return inv;
	}
	
}
