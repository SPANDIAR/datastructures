package com.spandiar.jpa.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.spandiar.jpa.transaction.dto.MenuItemServiceResponse;
import com.spandiar.jpa.transaction.model.MenuItem;
import com.spandiar.jpa.transaction.model.Restaurant;
import com.spandiar.jpa.transaction.processor.MenuItemService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(value = Restaurant.RESTAURANT)
public class MenuItemController {
	
	@Autowired
	private MenuItemService menuItemService;
	private static Logger logger = LoggerFactory.getLogger(MenuItemController.class); 
	
	@RequestMapping(method = RequestMethod.POST, value=Restaurant.MENUITEM)
	public void addItem(@RequestBody MenuItem itemToAdd) {
		try {
			menuItemService.addMenuItem(itemToAdd);
		} catch(Exception exc) {
			logger.error(exc.getMessage());
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, value=Restaurant.MENUITEM + "/{itemId}")
	public void updateItem(@PathVariable("itemId") String itemId,  @RequestBody MenuItem itemToUpdate) {
		
		System.out.println("itemId is: " + itemId);
		System.out.println("menuItem is: " + itemToUpdate.toString());
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = Restaurant.MENUITEM + "/{itemId}")
	public void deleteMenuItem(@PathVariable("itemId") String itemId) {
		try {
			menuItemService.deleteMenuItem(itemId);
		} catch(Exception exc) {
			logger.error(exc.getMessage());
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value=Restaurant.MENUITEM + "/{itemId}")
	public MenuItemServiceResponse getMenuItem(@PathVariable("itemId") String itemId ) {
		try {
			return menuItemService.getMenuItem(itemId);
		} catch(Exception exc) {
			logger.error(exc.getMessage());
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, exc.getMessage(), exc.getCause());
		}
	}
}
