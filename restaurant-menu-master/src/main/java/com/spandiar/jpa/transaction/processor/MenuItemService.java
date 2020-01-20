package com.spandiar.jpa.transaction.processor;

import java.util.Date;
import java.util.Iterator;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spandiar.jpa.transaction.dao.MenuItemDAO;
import com.spandiar.jpa.transaction.model.MenuItem;
import com.spandiar.jpa.transaction.model.MenuItem.MenuPrice;
import com.spandiar.jpa.transaction.model.Restaurant;

@Service
public class MenuItemService {
	
	@Autowired
	private MenuItemDAO menuItemDAO;
	
	public void addMenuItem(MenuItem itemToAdd) {
		enrichItemToAdd(itemToAdd);
		menuItemDAO.addItemsToMenu(itemToAdd);
	}
	
	public MenuItem getMenuItem(String itemId) {
		MenuItem itemFromMenu = menuItemDAO.getActiveItemFromMenu(itemId);
		enrichItemFromMenu(itemFromMenu);
		return itemFromMenu;
	}
	
	public void deleteMenuItem(String itemId) {
		menuItemDAO.deleteMenuItem(itemId);
	}
	
	private void enrichItemToAdd(final MenuItem itemToAdd) {
		
		itemToAdd.setStatus(Restaurant.ACTIVE);
		itemToAdd.setCreatedDate(new Date());
		itemToAdd.setCreatedBy(Restaurant.CREATEDBYADMIN);
		itemToAdd.getPrice().stream().forEach(price -> price.setItemId(itemToAdd.getItemId()));
		itemToAdd.getPrice().stream().forEach(price -> price.setCreatedDate(new Date()));
		itemToAdd.getPrice().stream().forEach(price -> price.setCreatedBy(Restaurant.CREATEDBYADMIN));
		itemToAdd.getPrice().stream().forEach(price -> price.setCurrency(Restaurant.CURRENCYINR));
	}
	
	private void enrichItemFromMenu(final MenuItem itemFromMenu) {
		Iterator<MenuPrice> menuPriceIterator = itemFromMenu.getPrice().iterator();
		while(menuPriceIterator.hasNext()) {
			MenuPrice menuPrice = menuPriceIterator.next();
			if(!checkActivePrice(menuPrice.getStartDate(), menuPrice.getEndDate())) {
				menuPriceIterator.remove();
			}
		}
	}
	
	 private boolean checkActivePrice(Date startDt, Date endDt) {
		Date today = new Date();
		if(startDt.before(today) && endDt.after(today)) {
			return true;
		}
		return false;
	}
}
