package com.spandiar.jpa.transaction.processor;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.spandiar.jpa.transaction.model.MenuItem;
import com.spandiar.jpa.transaction.model.MenuItem.MenuPrice;
import com.spandiar.jpa.transaction.model.Restaurant;

class MenuItemServiceTest {
	
	private MenuItemService menuItem;
	private MenuItem menuItemDetails;
	private MenuPrice menuItemPrice;
	private Restaurant.Cuisine cuisine;
	
	@BeforeAll
	void instansiate() {
		menuItem = new MenuItemService();
	}

	@Test
	void testAddMenuItem() {
		
		// Add an item to the menu
		menuItemDetails = new MenuItem();
		menuItemDetails.setItemId("SPR001");
		menuItemDetails.setItemName("Idly");
		menuItemDetails.setItemType(Restaurant.MAIN);
		//menuItemDetails.setItemCuisine(cuisine.INDIAN);
		menuItemDetails.setCreatedDate(new Date());
		menuItemDetails.setCreatedBy("Admin");
		
		menuItemPrice = new MenuPrice();
		menuItemPrice.setItemId("SPR001");
		menuItemPrice.setItemPrice(29.00F);
		menuItemPrice.setStartDate(new Date());
		menuItemPrice.setEndDate(new Date());
		menuItemPrice.setCurrency("INR");
		menuItemPrice.setCreatedDate(new Date());
		menuItemPrice.setCreatedBy("Admin");
		menuItemDetails.getPrice().add(menuItemPrice);
		
		
		menuItem.addMenuItem(menuItemDetails);
		
	}

}
