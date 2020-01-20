package com.spandiar.jpa.transaction.processor;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.spandiar.jpa.transaction.dto.MenuItemServiceResponse;
import com.spandiar.jpa.transaction.dto.MenuItemServiceResponse.MenuItemDetail;
import com.spandiar.jpa.transaction.model.MenuItem;

public class MenuItemEntityToResponseTransformer {
	
	private static MenuItemEntityToResponseTransformer INSTANCE;
	private MenuItemServiceResponse menuItemServiceResponse;
	
	public void copyEntityToResponse(final List<MenuItem> itemFromEntity) {
		
		menuItemServiceResponse = new MenuItemServiceResponse();
		List<MenuItemDetail> menuItemListServiceResponse = menuItemServiceResponse.getMenuItem();
		copyMenuItemDetail(menuItemListServiceResponse, itemFromEntity);
		
	}
	
	private void copyMenuItemDetail(final List<MenuItemDetail> menuItemListServiceResponse, final List<MenuItem> itemFromEntityList) {
		
		if(!CollectionUtils.isEmpty(itemFromEntityList)) {
			
			for(MenuItem itemFromEntity: itemFromEntityList) {
				
			}
			
			
			
		}
	}

	// private constructor
	private MenuItemEntityToResponseTransformer() {}
	
	// create a singleton object for this class
	public synchronized static MenuItemEntityToResponseTransformer getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MenuItemEntityToResponseTransformer();
		} 
		return INSTANCE;
	}
}
