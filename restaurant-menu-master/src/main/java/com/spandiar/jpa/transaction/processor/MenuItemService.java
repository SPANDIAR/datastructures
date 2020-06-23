package com.spandiar.jpa.transaction.processor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.spandiar.jpa.transaction.dao.MenuItemDAO;
import com.spandiar.jpa.transaction.dto.MenuItemServiceResponse;
import com.spandiar.jpa.transaction.dto.MenuItemServiceResponse.MenuItemDetail;
import com.spandiar.jpa.transaction.dto.MenuItemServiceResponse.MenuItemDetail.MenuPriceDetail;
import com.spandiar.jpa.transaction.model.MenuItem;
import com.spandiar.jpa.transaction.model.MenuItem.MenuPrice;
import com.spandiar.jpa.transaction.model.Restaurant;

@Service
public class MenuItemService {
	
	@Autowired
	private MenuItemDAO menuItemDAO;
	private List<MenuItem> menuItemListFromEntity;
	private MenuItemServiceResponse menuItemServiceResponse;
	private ModelMapper modelMapper;
	
	public void addMenuItem(MenuItem itemToAdd) {
		enrichItemToAdd(itemToAdd);
		menuItemDAO.addItemsToMenu(itemToAdd);
	}
	
	public MenuItemServiceResponse getMenuItem(String itemId) {
		menuItemListFromEntity = new ArrayList<>();
		MenuItem itemFromMenu = menuItemDAO.getActiveItemFromMenu(itemId);
		menuItemListFromEntity.add(itemFromMenu);
		copyEntityToResponseModel();
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
		itemToAdd.getPrice().stream().forEach(price -> price.setModifiedDate(new Date()));
		//itemToAdd.getPrice().stream().sorted(Comparator.comparing(MenuPrice::getEndDate)).forEach(MenuItemService::updateItemPriceId());
		List<MenuPrice> priceItemUpdateList = itemToAdd.getPrice().stream().sorted(Comparator.comparing(MenuPrice::getEndDate)).collect(Collectors.toList());
		updateItemPriceId(priceItemUpdateList);
	}
	
	private void enrichItemFromMenu(MenuItemDetail menuItemDetail) {
		Iterator<MenuPriceDetail> menuPriceIterator = menuItemDetail.getMenuPrice().iterator();
		while(menuPriceIterator.hasNext()) {
			MenuPriceDetail menuPrice = menuPriceIterator.next();
			if(checkActivePrice(menuPrice.getStartDate(), menuPrice.getEndDate())) {
				menuPrice.setActive(true);
			}
		}
	}
	
	private void updateItemPriceId(List<MenuPrice> priceItemUpdateList) {
		int i=1;
		for(MenuPrice priceItemUpdate: priceItemUpdateList) {
			priceItemUpdate.setItemPriceId(i);
			i++;
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
		 modelMapper = new ModelMapper();
		 menuItemServiceResponse = new MenuItemServiceResponse();
		 List <MenuItemServiceResponse.MenuItemDetail> menuItemListDetail = new ArrayList<>();
		 MenuItemServiceResponse.MenuItemDetail menuItemDetail = new MenuItemServiceResponse.MenuItemDetail();
		 if(!CollectionUtils.isEmpty(menuItemListFromEntity)) {
			 for(MenuItem menuItemFromEntity: menuItemListFromEntity) {
				 modelMapper.map(menuItemFromEntity, menuItemDetail);
				 enrichItemFromMenu(menuItemDetail);
				 menuItemListDetail.add(menuItemDetail);
			 }
			 menuItemServiceResponse.setMenuItem(menuItemListDetail);
		 }
	 }
}
