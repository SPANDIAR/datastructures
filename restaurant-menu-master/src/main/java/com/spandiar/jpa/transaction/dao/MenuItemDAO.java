package com.spandiar.jpa.transaction.dao;


import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.spandiar.jpa.transaction.model.MenuItem;

@Repository
public class MenuItemDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void addItemsToMenu(MenuItem itemToAdd) {
		entityManager.persist(itemToAdd);
	}
	
	public MenuItem getItemFromMenu(String itemId) {
		return entityManager.find(MenuItem.class, itemId);
	}
	
	public MenuItem getActiveItemFromMenu(String itemId) {
		String activeMenuItem = "select item_Id, item_Name, item_Type, status, created_by, created_date from menuitem where status = :status and item_Id = :itemId";
		Query activeMenuItemQuery = entityManager.createNativeQuery(activeMenuItem, MenuItem.class).setParameter("itemId", itemId).setParameter("status",  "A");
		return (MenuItem) activeMenuItemQuery.getSingleResult();
	}
	
	@Transactional
	public void deleteMenuItem(String itemId) {
		String updateStatusToInactive = "update menuitem set status = :Deleted where item_id = :itemId";
		Query deleteMenuItem = entityManager.createNativeQuery(updateStatusToInactive).setParameter("Deleted", "D").setParameter("itemId", itemId);
		deleteMenuItem.executeUpdate();
	}
}
