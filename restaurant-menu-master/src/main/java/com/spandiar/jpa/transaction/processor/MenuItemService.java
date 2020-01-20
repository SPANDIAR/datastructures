package com.spandiar.jpa.transaction.processor;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.spandiar.jpa.transaction.dao.MenuItemDAO;
import com.spandiar.jpa.transaction.dto.MenuItemServiceResponse;
import com.spandiar.jpa.transaction.dto.MenuItemServiceResponse.MenuItemDetail;
import com.spandiar.jpa.transaction.model.MenuItem;
import com.spandiar.jpa.transaction.model.MenuItem.MenuPrice;
import com.spandiar.jpa.transaction.model.Restaurant;

@Service
public class MenuItemService {
	
	@Autowired
	private MenuItemDAO menuItemDAO;
	private MenuItemEntityToResponseTransformer entityToServiceResponse;
	private List<MenuItem> menuItemListFromEntity;
	private MenuItemServiceResponse menuItemServiceResponse;
	
	public void addMenuItem(MenuItem itemToAdd) {
		enrichItemToAdd(itemToAdd);
		menuItemDAO.addItemsToMenu(itemToAdd);
	}
	
	public MenuItemServiceResponse getMenuItem(String itemId) {
		MenuItem itemFromMenu = menuItemDAO.getActiveItemFromMenu(itemId);
		menuItemListFromEntity.add(itemFromMenu);
		copyEntityToResponseModel();
		//entityToServiceResponse.copyEntityToResponse(menuItemListFromEntity);
		//enrichItemFromMenu(itemFromMenu);
		return menuItemServiceResponse;
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
	 
	 private void copyEntityToResponseModel() {
		
		 MenuItemServiceResponse.MenuItemDetail menuItemDetail = new MenuItemServiceResponse.MenuItemDetail();
		 ModelMapper modelMapper = new ModelMapper();
		 
		 if(!CollectionUtils.isEmpty(menuItemListFromEntity)) {
			 for(MenuItem menuItemFromEntity: menuItemListFromEntity) {
				 modelMapper.map(menuItemFromEntity, menuItemDetail);
				 menuItemServiceResponse.setMenuItem(List.of(menuItemDetail));
			 }
		 }
	 }

	public MenuItemService() {
		entityToServiceResponse =  MenuItemEntityToResponseTransformer.getInstance();
		menuItemListFromEntity = new ArrayList<>();
		menuItemServiceResponse = new MenuItemServiceResponse();
	}
}
