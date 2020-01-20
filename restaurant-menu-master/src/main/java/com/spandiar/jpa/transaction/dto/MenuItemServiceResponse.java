package com.spandiar.jpa.transaction.dto;

import java.util.Date;
import java.util.List;

public class MenuItemServiceResponse {

	private List<MenuItemDetail> menuItem;

	public static class MenuItemDetail {

		private String itemId;
		private String itemName;
		private String itemType;
		private List<MenuPriceDetail> menuPrice;
		private Date createdDate;
		private String createdBy;

		public static class MenuPriceDetail {

			private float itemPrice;
			private String currency;
			private Date startDate;
			private Date endDate;
			private boolean isActive;
			private Date createdDate;
			private String createdBy;
			
			public float getItemPrice() {
				return itemPrice;
			}
			public void setItemPrice(float itemPrice) {
				this.itemPrice = itemPrice;
			}
			public String getCurrency() {
				return currency;
			}
			public void setCurrency(String currency) {
				this.currency = currency;
			}
			public Date getStartDate() {
				return startDate;
			}
			public void setStartDate(Date startDate) {
				this.startDate = startDate;
			}
			public Date getEndDate() {
				return endDate;
			}
			public void setEndDate(Date endDate) {
				this.endDate = endDate;
			}
			public boolean isActive() {
				return isActive;
			}
			public void setActive(boolean isActive) {
				this.isActive = isActive;
			}
			public Date getCreatedDate() {
				return createdDate;
			}
			public void setCreatedDate(Date createdDate) {
				this.createdDate = createdDate;
			}
			public String getCreatedBy() {
				return createdBy;
			}
			public void setCreatedBy(String createdBy) {
				this.createdBy = createdBy;
			}
			
			public MenuPriceDetail() {
				super();
			}
		}

		public String getItemId() {
			return itemId;
		}

		public void setItemId(String itemId) {
			this.itemId = itemId;
		}

		public String getItemName() {
			return itemName;
		}

		public void setItemName(String itemName) {
			this.itemName = itemName;
		}

		public String getItemType() {
			return itemType;
		}

		public void setItemType(String itemType) {
			this.itemType = itemType;
		}

		public List<MenuPriceDetail> getMenuPrice() {
			return menuPrice;
		}

		public void setMenuPrice(List<MenuPriceDetail> menuPrice) {
			this.menuPrice = menuPrice;
		}

		public Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}

		public String getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}

		public MenuItemDetail() {
			super();
		}
		
	}

	public List<MenuItemDetail> getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(List<MenuItemDetail> menuItem) {
		this.menuItem = menuItem;
	}

	public MenuItemServiceResponse() {
		super();
	}	
	
}

