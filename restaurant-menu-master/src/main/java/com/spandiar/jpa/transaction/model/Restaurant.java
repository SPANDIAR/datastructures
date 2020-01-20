package com.spandiar.jpa.transaction.model;

public interface Restaurant {
	
	// controller constants
	
	static final String RESTAURANT = "/restaurant";
	static final String MENUITEM = "/menuitem";
	
	// menuItems
	
	static final String APPETIZER = "Appetizer";
	static final String SOUP = "Soup";
	static final String MAIN = "Main Course";
	static final String DESSERT = "Dessert";
	static final String DRINK = "Drinks";
	static final String SNACKS = "Snacks";
	static final String ACTIVE = "A";
	
	// menuCategory
	
	enum Cuisine {
		SINDIAN, NINDIAN, CHINESE, CONTINENTAL;
	}
	
	// Miscellaneous constants
	
	static final String CREATEDBYADMIN = "Admin";
	static final String CURRENCYINR = "INR";
	static final String CURRENCYUSD = "USD";


}
